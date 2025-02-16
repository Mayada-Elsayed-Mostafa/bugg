package com.example.productsappmvp.allproducts.view;

import com.example.productsappmvp.model.Product;

import java.util.List;

public interface AllProductsView {

    void setData(List<Product> productList);

    void showErrMsg(String err);
}
