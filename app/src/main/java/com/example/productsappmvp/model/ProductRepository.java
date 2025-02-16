package com.example.productsappmvp.model;


import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.productsappmvp.db.AppDatabase;
import com.example.productsappmvp.db.ProductDao;
import com.example.productsappmvp.db.ProductLocalDataSource;
import com.example.productsappmvp.network.APIProduct;
import com.example.productsappmvp.network.NetworkCallback;

import java.util.List;

public class ProductRepository {

    ProductLocalDataSource localDataSource;
    APIProduct remoteDataSource;

    //why?
    ProductDao productDao;

    private static ProductRepository repo = null;

    private ProductRepository(ProductLocalDataSource localDataSource , APIProduct remoteDataSource)
    {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static ProductRepository getInstance(ProductLocalDataSource localDataSource , APIProduct remoteDataSource) {
        if (repo == null) {
            repo = new ProductRepository(localDataSource, remoteDataSource);
        }
        return repo;
    }

    public LiveData<List<Product>> getAllData(){
        return localDataSource.getData();
    }

    //this
    public void insert(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.insertProduct(product);
            }
        }).start();
    }

    //this
    public void delete(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.deleteProduct(product);
            }
        }).start();
    }

    //add network con.



    public void getAllData(NetworkCallback networkCallBack)
    {
        remoteDataSource.getDataOverNetwork(networkCallBack);
    }
}
