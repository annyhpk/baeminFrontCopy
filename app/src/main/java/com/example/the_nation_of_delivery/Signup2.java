package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Random;


public class Signup2 extends AppCompatActivity {
    String et_nickname_val;
    String et_email_val;
    String et_password_val;

    EditText et_phone_num;
    EditText et_c_n;
    Button btn_finish;
    Button btn_phone;

    Random ran = new Random();

    String res = Integer.toString(ran.nextInt(8999) + 1000);

    SQLiteDatabase sqliteDB ;

    private SQLiteDatabase init_database() {

        SQLiteDatabase db = null ;
        // File file = getDatabasePath("contact.db") ;
        File file = new File(getFilesDir(), "member.db") ;

        System.out.println("PATH : " + file.toString()) ;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(file, null) ;
        } catch (SQLiteException e) {
            e.printStackTrace() ;
        }

        if (db == null) {
            System.out.println("DB 생성 실패. " + file.getAbsolutePath()) ;
        }

        return db ;
    }

    private void init_tables() {

        if (sqliteDB != null) {
            String sqlCreateTbl = "CREATE TABLE IF NOT EXISTS MEMBER(" +
                    "NAME "         + "TEXT," +
                    "EMAIL "        + "TEXT," +
                    "PASSWD "       + "TEXT" + ")" ;

            System.out.println(sqlCreateTbl) ;

            sqliteDB.execSQL(sqlCreateTbl) ;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        Intent intent2 = getIntent();
        et_email_val = intent2.getStringExtra("et_email_val");
        et_nickname_val = intent2.getStringExtra("et_nickname_val");
        et_password_val = intent2.getStringExtra("et_password_val");

        et_phone_num = (EditText)findViewById(R.id.et_phone_num);
        et_c_n = (EditText)findViewById(R.id.et_validate);
        btn_finish = (Button)findViewById(R.id.btn_finish);
        btn_phone = (Button)findViewById(R.id.btn_validate);

        btn_finish.setEnabled(false);

        et_c_n.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_c_n.getText().toString().length() == 4){
                    btn_finish.setBackgroundColor(Color.rgb(26, 211, 211));
                    btn_finish.setTextColor(Color.WHITE);
                    btn_finish.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_c_n.setText(res);
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(res.equals(et_c_n.getText().toString())){
                    sqliteDB = init_database() ;
                    init_tables() ;

                    String sqlInsert = "INSERT INTO MEMBER " +
                            "(NAME, EMAIL, PASSWD) VALUES (" +
                            "'" + et_nickname_val + "'," +
                            "'" + et_email_val + "'," +
                            "'" + et_password_val + "'" + ")" ;

                    System.out.println(sqlInsert) ;
                    sqliteDB.execSQL(sqlInsert) ;

                    finish();
                    Toast toast = Toast.makeText(Signup2.this, "배민 회원이 되신 걸 환영합니다.", Toast.LENGTH_LONG);
                    toast.show();

                }
            }
        });
    }
}