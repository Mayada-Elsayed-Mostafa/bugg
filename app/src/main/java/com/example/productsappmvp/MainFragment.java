package com.example.productsappmvp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {


    Button allProducts;
    Button favProducts;
    Button exit;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        allProducts = view.findViewById(R.id.btn_all);
        favProducts = view.findViewById(R.id.btn_fav);


        allProducts.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_allProductsFragment);
        });

        favProducts.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_favoriteProductsFragment);
        });

        return view;
    }


}