package com.example.productsappmvp.favproducts.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productsappmvp.R;
import com.example.productsappmvp.allproducts.view.AllProductsAdapter;
import com.example.productsappmvp.db.ProductLocalDataSource;
import com.example.productsappmvp.favproducts.presenter.FavProducts;
import com.example.productsappmvp.model.Product;
import com.example.productsappmvp.model.ProductRepository;
import com.example.productsappmvp.network.APIProduct;

import java.util.ArrayList;
import java.util.List;
public class FavoriteProductsFragment extends Fragment implements OnFavProductsClickListener {

    FavProducts favProducts;
    AllProductsAdapter productsAdapter;
    RecyclerView recyclerView;

    public FavoriteProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_products, container, false);

        recyclerView = view.findViewById(R.id.rv_product2);

        productsAdapter = new AllProductsAdapter(new ArrayList<>(), getContext(), this, true);
        recyclerView.setAdapter(productsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        favProducts = new FavProducts(ProductRepository.getInstance(ProductLocalDataSource.getInstance(getContext()),APIProduct.getInstance()), this);

        favProducts.getFavData().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productList) {
                productsAdapter.setList(productList);
                productsAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onFavProductClicked(Product product) {
        favProducts.delete(product);
        Toast.makeText(getContext(), "Product Deleted", Toast.LENGTH_SHORT).show();

        favProducts.getFavData().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> updatedProductList) {
                productsAdapter.setList(updatedProductList);
                productsAdapter.notifyDataSetChanged();
            }
        });
    }
}
