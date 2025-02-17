package com.example.productsappmvp.model;


import androidx.lifecycle.LiveData;

import com.example.productsappmvp.db.ProductDao;
import com.example.productsappmvp.db.ProductLocalDataSource;
import com.example.productsappmvp.network.APIProduct;
import com.example.productsappmvp.network.NetworkCallback;

import java.util.List;

public class ProductRepository {

    ProductLocalDataSource localDataSource;
    APIProduct remoteDataSource;


    private static ProductRepository repo = null;

    private ProductRepository(ProductLocalDataSource localDataSource, APIProduct remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static ProductRepository getInstance(ProductLocalDataSource localDataSource, APIProduct remoteDataSource) {
        if (repo == null) {
            repo = new ProductRepository(localDataSource, remoteDataSource);
        }
        return repo;
    }

    public LiveData<List<Product>> getAllData() {
        return localDataSource.getData();
    }

    public void insert(Product product) {

        localDataSource.insert(product);

    }

    public void delete(Product product) {

        localDataSource.delete(product);

    }


    public void getAllData(NetworkCallback networkCallBack) {
        remoteDataSource.getDataOverNetwork(networkCallBack);
    }
}
