package com.example.productsappmvp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "producttable")
public class Product {

    @PrimaryKey
    @NonNull
    private Long id;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String title;
    public double price;
    public String brand;
    public String description;
    public double rating;
    public String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

}
