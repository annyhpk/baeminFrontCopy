package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Thread.sleep(1000); //메인로고 타이머
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, subMainActivity.class)); //메인화면 출력
        finish();
    }
}
