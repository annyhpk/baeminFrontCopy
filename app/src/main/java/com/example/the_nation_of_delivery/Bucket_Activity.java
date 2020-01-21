package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bucket_Activity extends AppCompatActivity {

    Button order;
    TextView all_rm, more_menu, count, minus, plus, price;
    int count_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        order = (Button)findViewById(R.id.btn_order);
        all_rm = (TextView)findViewById(R.id.all_rm);
        more_menu = (TextView)findViewById(R.id.more_menu);
        count = (TextView)findViewById(R.id.menu_count);
        minus = (TextView)findViewById(R.id.minus);
        plus = (TextView)findViewById(R.id.plus);
        price = (TextView)findViewById(R.id.price);

        minus.setClickable(true);
        plus.setClickable(true);
        all_rm.setClickable(true);
        more_menu.setClickable(true);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = count.getText().toString().indexOf("개");
                count_menu = Integer.parseInt(count.getText().toString().substring(0,i));
                if(count_menu > 1){
                    count_menu--;
                    count.setText(count_menu+"개");
                    price.setText(String.format("%,d",count_menu*15900)+"원");
                    order.setText(String.format("%,d",count_menu*15900)+"원 배달 주문하기");
                } else {

                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = count.getText().toString().indexOf("개");
                count_menu = Integer.parseInt(count.getText().toString().substring(0,i));
                count_menu++;
                count.setText(count_menu+"개");
                price.setText(String.format("%,d",count_menu*15900)+"원");
                order.setText(String.format("%,d",count_menu*15900)+"원 배달 주문하기");
            }
        });

        more_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        all_rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = count.getText().toString().indexOf("개");
                count_menu = Integer.parseInt(count.getText().toString().substring(0,i));
                Intent intent = new Intent(Bucket_Activity.this, Payment_Activity.class);
                intent.putExtra("price", String.format("%,d",count_menu*15900));
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
