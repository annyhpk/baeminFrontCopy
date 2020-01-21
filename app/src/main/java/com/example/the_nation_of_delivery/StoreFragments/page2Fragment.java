package com.example.the_nation_of_delivery.StoreFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.the_nation_of_delivery.R;

public class page2Fragment extends Fragment  {

    public page2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_fragment_pagetwo, null);

        return view;
    }

    public static page2Fragment newInstance() {
        Bundle args = new Bundle();

        page2Fragment fragment = new page2Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
