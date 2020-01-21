package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    Button btn_next;
    EditText et_nickname, et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        btn_next = (Button) findViewById(R.id.btn_next);
        et_nickname = (EditText) findViewById(R.id.et_nickname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);

        btn_next.setEnabled(false);

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_nickname.getText().toString().length() >= 2 && et_email.getText().toString().length() >= 1 && et_password.getText().toString().length() >= 8){
                    btn_next.setBackgroundColor(Color.rgb(26, 211, 211));
                    btn_next.setTextColor(Color.WHITE);
                    btn_next.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Signup.this, Signup2.class);
                intent.putExtra("et_nickname_val", et_nickname.getText().toString());
                intent.putExtra("et_email_val", et_email.getText().toString());
                intent.putExtra("et_password_val", et_password.getText().toString());
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
