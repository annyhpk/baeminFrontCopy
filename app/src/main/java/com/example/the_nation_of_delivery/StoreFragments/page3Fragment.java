package com.example.the_nation_of_delivery.StoreFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.the_nation_of_delivery.R;

public class page3Fragment extends Fragment  {

    public page3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_fragment_pagethree, null);

        return view;
    }

    public static page3Fragment newInstance() {
        Bundle args = new Bundle();

        page3Fragment fragment = new page3Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
