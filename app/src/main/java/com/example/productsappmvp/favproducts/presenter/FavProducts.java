package com.example.productsappmvp.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.productsappmvp.allproducts.view.AllProductsFragment;
import com.example.productsappmvp.favproducts.view.FavoriteProductsFragment;
import com.example.productsappmvp.model.Product;
import com.example.productsappmvp.model.ProductRepository;

import java.util.List;

public class FavProducts {

    ProductRepository productRepository;
    AllProductsFragment allProductsFragment;

    public FavProducts(ProductRepository productRepository, FavoriteProductsFragment favoriteProductsFragment) {
        this.productRepository = productRepository;
        this.allProductsFragment = allProductsFragment;
    }

    public LiveData<List<Product>> getFavData() {
        return productRepository.getAllData();
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }
}


