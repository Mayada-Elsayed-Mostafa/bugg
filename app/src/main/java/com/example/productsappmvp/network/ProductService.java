package com.example.productsappmvp.network;


import com.example.productsappmvp.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
