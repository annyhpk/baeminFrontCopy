package com.example.the_nation_of_delivery.StoreFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.the_nation_of_delivery.Bucket_Activity;
import com.example.the_nation_of_delivery.ExpandAdapter;
import com.example.the_nation_of_delivery.Login;
import com.example.the_nation_of_delivery.Login_process;
import com.example.the_nation_of_delivery.R;
import com.example.the_nation_of_delivery.myGroup;

import java.util.ArrayList;

public class page1Fragment extends Fragment  {
    ExpandableListView listView;
    LinearLayout best_menu;

    public page1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_fragment_pageone, null);
        Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ArrayList<myGroup> DataList = new ArrayList<>();
        listView = (ExpandableListView) view.findViewById(R.id.listview);
        myGroup temp = new myGroup(" 메인메뉴");
        temp.child.add("후라이드 치킨");
        temp.child.add("양념 치킨");
        temp.child.add("반반 치킨");
        DataList.add(temp);

        ExpandAdapter adapter = new ExpandAdapter(view.getContext().getApplicationContext(),R.layout.group_row,R.layout.child_row,DataList);
        listView.setIndicatorBounds(width-100, width); //이 코드를 지우면 화살표 위치가 바뀐다.
        listView.setAdapter(adapter);
        listView.expandGroup(0);

        best_menu = (LinearLayout)view.findViewById(R.id.best_menu);
        best_menu.setClickable(true);

        best_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Login_process.login_process != null) {
                    Intent intent = new Intent(getActivity(), Bucket_Activity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getActivity(), "로그인 후 이용해주세요.", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivity(intent);
                }
            }
        });


        return view;
    }

    public static page1Fragment newInstance() {
        Bundle args = new Bundle();

        page1Fragment fragment = new page1Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
