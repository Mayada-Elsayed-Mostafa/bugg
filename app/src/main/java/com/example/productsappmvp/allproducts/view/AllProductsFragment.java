package com.example.productsappmvp.allproducts.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productsappmvp.R;
import com.example.productsappmvp.allproducts.presenter.AllProductsImp;
import com.example.productsappmvp.db.ProductLocalDataSource;
import com.example.productsappmvp.model.Product;
import com.example.productsappmvp.model.ProductRepository;
import com.example.productsappmvp.network.APIProduct;

import java.util.ArrayList;
import java.util.List;

public class AllProductsFragment extends Fragment implements OnAllProductsClickListener, AllProductsView {


    AllProductsAdapter productsAdapter;
    RecyclerView allRecyclerView;
    AllProductsImp allProductsImp;
    Context context;


    public AllProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        allRecyclerView = view.findViewById(R.id.rv_product);


        allProductsImp = new AllProductsImp(ProductRepository.getInstance(ProductLocalDataSource.getInstance(getContext()) ,APIProduct.getInstance()), this);

        allProductsImp.getData();

        productsAdapter = new AllProductsAdapter(new ArrayList<>(), context, this, false);
        allRecyclerView.setAdapter(productsAdapter);
        allRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_all_products, container, false);
    }

    @Override
    public void setData(List<Product> productList) {
        productsAdapter.setList(productList);
    }

    @Override
    public void showErrMsg(String err) {

    }

    @Override
    public void onAddProductClicked(Product product) {
        allProductsImp.addFav(product);
    }
}