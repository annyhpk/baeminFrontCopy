package com.example.the_nation_of_delivery.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.the_nation_of_delivery.R;
import com.example.the_nation_of_delivery.store_menu_Activity;

public class page6Fragment extends Fragment {
    LinearLayout store1;
    public page6Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pageone, null);

        store1 = (LinearLayout) view.findViewById(R.id.layout_restaurant);
        store1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), store_menu_Activity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public static page6Fragment newInstance() {
        Bundle args = new Bundle();

        page6Fragment fragment = new page6Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
