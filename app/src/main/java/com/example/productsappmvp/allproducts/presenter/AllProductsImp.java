package com.example.productsappmvp.allproducts.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.productsappmvp.allproducts.view.AllProductsFragment;
import com.example.productsappmvp.allproducts.view.AllProductsView;
import com.example.productsappmvp.model.Product;
import com.example.productsappmvp.model.ProductRepository;
import com.example.productsappmvp.network.NetworkCallback;

import java.util.List;

public class AllProductsImp implements NetworkCallback {

    private ProductRepository productRepository;

    private AllProductsView allProductsView;
    private AllProductsFragment allProductsFragment;


    public AllProductsImp(ProductRepository productRepository, AllProductsView allProductsView) {
        this.productRepository = productRepository;
        this.allProductsView = allProductsView;
    }

    public void getData()
    {
        productRepository.getAllData(this);
    }
    public void addFav(Product product)
    {
        productRepository.insert(product);
    }

    @Override
    public void onSuccess(List<Product> products) {
        allProductsView.setData(products);

        Log.d("TAG", "onSuccess: " + products.size());
    }

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText((Context) allProductsView, errorMessage, Toast.LENGTH_SHORT).show();
    }


}
