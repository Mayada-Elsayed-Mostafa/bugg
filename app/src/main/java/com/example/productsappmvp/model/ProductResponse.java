package com.example.productsappmvp.model;


import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public ProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}
