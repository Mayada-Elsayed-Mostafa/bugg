//this
package com.example.productsappmvp.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.productsappmvp.model.Product;

import java.util.List;

public class ProductLocalDataSource {

    private ProductDao dao;
    private LiveData<List<Product>> data;

    private static ProductLocalDataSource productLocalDataSource = null;

    private ProductLocalDataSource(Context context) {

        AppDatabase appDatabase = AppDatabase.getInstance(context.getApplicationContext());
        dao = appDatabase.getProductDao();
        data = dao.getFavoriteProducts();

    }

    public static ProductLocalDataSource getInstance(Context context) {

        if (productLocalDataSource == null) {
            productLocalDataSource  = new ProductLocalDataSource(context);
        }
        return productLocalDataSource;
    }

    public LiveData<List<Product>> getData() {
        return data;
    }

    public void insert(Product product) {
        new Thread(() -> {
            dao.insertProduct(product);
        }).start();
    }

    public void delete(Product product) {
        new Thread(() -> {
            dao.deleteProduct(product);
        }).start();
    }
}
