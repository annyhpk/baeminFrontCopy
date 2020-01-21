package com.example.the_nation_of_delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Location extends AppCompatActivity {

    EditText juso;
    Button btn_juso;
    ImageButton X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        X = (ImageButton)findViewById(R.id.cancel);
        juso = (EditText)findViewById(R.id.et_search);
        btn_juso = (Button)findViewById(R.id.btn_cur_location);

        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_juso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subMainActivity.my_location.setText(juso.getText().toString());
                finish();
            }
        });
    }
}
