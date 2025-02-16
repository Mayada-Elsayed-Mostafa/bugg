package com.example.productsappmvp.network;


import com.example.productsappmvp.model.Product;

import java.util.List;

public interface NetworkCallback {
    void onSuccess(List<Product> products);

    void onFailure(String errorMessage);
}
