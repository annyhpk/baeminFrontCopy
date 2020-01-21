package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;


public class Login extends AppCompatActivity {

    LinearLayout btn_signup;
    Button btn_login;
    EditText et_login_id;
    EditText et_login_pw;
    String str_id, str_pw, db_pw;
    ImageButton cancel;

    SQLiteDatabase sqliteDB;

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
        setContentView(R.layout.activity_login);

        cancel = (ImageButton) findViewById(R.id.cancel);
        et_login_id = (EditText) findViewById(R.id.et_login_id);
        et_login_pw = (EditText) findViewById(R.id.et_login_pw);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_signup = (LinearLayout) findViewById(R.id.btn_signup);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_login(et_login_id.getText().toString(), et_login_pw.getText().toString()) ) {
                    Login_process.login_process = et_login_id.getText().toString();
                    subMainActivity.login_check();
                    finish();
                    Toast toast = Toast.makeText(Login.this, "로그인 성공!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(Login.this, "아이디 혹은 비밀번호를 확인해주세요.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    public boolean btn_login(String id, String pw)
        {
        str_id = id;
        str_pw = pw;

        sqliteDB = init_database() ;

        String sqlInsert = "SELECT PASSWD FROM MEMBER WHERE EMAIL =" + "'" + str_id + "'" + ";";
        Cursor result = sqliteDB.rawQuery(sqlInsert, null);
            if(result.moveToFirst()){
                db_pw = result.getString(0);
            }
            result.close();

        if(str_pw.equals(db_pw))
        {
            /* 패스워드 확인이 정상적으로 됨 */
            return true;

        }
        else
        {
            /* 패스워드 확인이 불일치 함 */
            return false;
        }
    }

}