package com.example.productsappmvp.network;


import android.util.Log;

import com.example.productsappmvp.model.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIProduct {

    private static String BASE_URL = "https://dummyjson.com/";
    private ProductService productService;

    //this
    private static APIProduct apiProduct = null;

    public APIProduct() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productService = retrofit.create(ProductService.class);

    }

    //this
    public static APIProduct getInstance() {
        if (apiProduct == null) {
            apiProduct = new APIProduct();
        }
        return apiProduct;
    }

    public void getDataOverNetwork(NetworkCallback callback) {

        Call<ProductResponse> call =  productService.getProducts();
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                Log.i("TAG", "onResponse: "+response.body().getProducts().size());
                callback.onSuccess(response.body().getProducts());
                Log.i("TAG", "onResponse: " + response.body().getProducts().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable throwable) {
                Log.i("TAG", "onFailure: ");
                throwable.printStackTrace();
                callback.onFailure(throwable.getMessage());
            }
        });
    }
}