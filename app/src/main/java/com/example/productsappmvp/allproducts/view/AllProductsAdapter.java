package com.example.productsappmvp.allproducts.view;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.productsappmvp.R;
import com.example.productsappmvp.favproducts.view.OnFavProductsClickListener;
import com.example.productsappmvp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList = new ArrayList<>();
    private OnAllProductsClickListener listener;
    private OnFavProductsClickListener listener2;
    Boolean isFav;


    public AllProductsAdapter(List<Product> _productList, Context context, OnAllProductsClickListener listener, Boolean isFavScreen) {
        this.productList = _productList;
        this.context = context;
        this.listener = listener;
        this.isFav = isFavScreen;
    }

    public AllProductsAdapter(List<Product> _productList, Context context, OnFavProductsClickListener listener, Boolean isFavScreen) {
        this.productList = _productList;
        this.context = context;
        this.listener2 = listener;
        this.isFav = isFavScreen;
    }

    public void setList(List<Product> products) {
        this.productList = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Product product = productList.get(position);
//
//        Log.d("ImageURL", "URL: " + product.getThumbnail());
//        Glide.with(context)
//                .load(product.getThumbnail())
//                .into(holder.productIV);
//        holder.titleTV.setText(product.getTitle());
//        holder.priceTV.setText(String.format("$%.2f", product.getPrice()));
//        holder.brandTV.setText(product.getBrand());
//        holder.descTV.setText(product.getDescription());
//        holder.ratingBar.setRating((float) product.getRating());
//
//        // cond
//        if (isFav) {
//            holder.add.setOnClickListener(v -> listener2.onFavProductClicked(product));
//        } else holder.add.setOnClickListener(v -> listener.onAddProductClicked(product));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productIV;
        TextView titleTV, priceTV, brandTV, descTV;
        RatingBar ratingBar;
        Button add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            productIV = itemView.findViewById(R.id.product_iv);
//            titleTV = itemView.findViewById(R.id.titleValue_tv);
//            priceTV = itemView.findViewById(R.id.priceValue_tv);
//            brandTV = itemView.findViewById(R.id.brandValue_tv);
//            descTV = itemView.findViewById(R.id.descriptionValue_tv);
//            ratingBar = itemView.findViewById(R.id.rating_star);
//            add = itemView.findViewById(R.id.btn_add);
        }
    }
}
