package com.example.productsappmvp.allproducts.presenter;

import com.example.productsappmvp.model.Product;

public interface AllProducts {

    public void getProducts();
    public void addToFav(Product product);
}
