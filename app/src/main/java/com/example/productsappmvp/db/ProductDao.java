package com.example.productsappmvp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.productsappmvp.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM producttable")
    LiveData<List<Product>> getFavoriteProducts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);


}
