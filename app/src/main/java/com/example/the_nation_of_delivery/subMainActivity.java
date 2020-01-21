package com.example.the_nation_of_delivery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class subMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout location;
    ImageButton koreanfood, boonsik, cafe_dessert;
    ImageButton donggas , chicken, pizza;
    ImageButton jjajang, zokbal, nightfood;
    ImageButton zzim, tosirak, fastfood;
    ImageButton franchise, ranking;
    static Button btn_login, logout;
    static TextView nick, my_location;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        location = (LinearLayout)findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(subMainActivity.this, Location.class)); }
        });

        logout = (Button)(navigationView.getHeaderView(0).findViewById(R.id.btn_logout));
        nick = (TextView)(navigationView.getHeaderView(0).findViewById(R.id.user_nickname));

        my_location = (TextView)findViewById(R.id.location_name);

        koreanfood = (ImageButton)findViewById(R.id.koreanfood);
        boonsik = (ImageButton)findViewById(R.id.boonsik);
        cafe_dessert = (ImageButton)findViewById(R.id.cafe_dessert);
        donggas = (ImageButton)findViewById(R.id.donggas);
        chicken = (ImageButton)findViewById(R.id.chicken);
        pizza = (ImageButton)findViewById(R.id.pizza);
        jjajang = (ImageButton)findViewById(R.id.jjajang);
        zokbal = (ImageButton)findViewById(R.id.zokbal);
        nightfood = (ImageButton)findViewById(R.id.nightfood);
        zzim = (ImageButton)findViewById(R.id.zzim);
        tosirak = (ImageButton)findViewById(R.id.tosirak);
        fastfood = (ImageButton)findViewById(R.id.fastfood);
        franchise = (ImageButton)findViewById(R.id.franchise);
        ranking = (ImageButton)findViewById(R.id.ranking);

        logout.setVisibility(View.GONE);

        ImageButton.OnClickListener btnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch(v.getId()) { //메뉴 이동
                    case R.id.koreanfood:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 0);
                        startActivity(intent);
                        break;
                    case R.id.boonsik:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 1);
                        startActivity(intent);
                        break;
                    case R.id.cafe_dessert:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 2);
                        startActivity(intent);
                        break;
                    case R.id.donggas:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 3);
                        startActivity(intent);
                        break;
                    case R.id.chicken:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 4);
                        startActivity(intent);
                        break;
                    case R.id.pizza:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 5);
                        startActivity(intent);
                        break;
                    case R.id.jjajang:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 6);
                        startActivity(intent);
                        break;
                    case R.id.zokbal:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 7);
                        startActivity(intent);
                        break;
                    case R.id.nightfood:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 8);
                        startActivity(intent);
                        break;
                    case R.id.zzim:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 9);
                        startActivity(intent);
                        break;
                    case R.id.tosirak:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 10);
                        startActivity(intent);
                        break;
                    case R.id.fastfood:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 11);
                        startActivity(intent);
                        break;
                    case R.id.franchise:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 12);
                        startActivity(intent);
                        break;
                    case R.id.ranking:
                        intent = new Intent(subMainActivity.this, MenuActivity.class);
                        intent.putExtra("menu", 13);
                        startActivity(intent);
                        break;
                }
            }
        };
        koreanfood.setOnClickListener(btnClickListener);
        boonsik.setOnClickListener(btnClickListener);
        cafe_dessert.setOnClickListener(btnClickListener);
        donggas.setOnClickListener(btnClickListener);
        chicken.setOnClickListener(btnClickListener);
        pizza.setOnClickListener(btnClickListener);
        jjajang.setOnClickListener(btnClickListener);
        zokbal.setOnClickListener(btnClickListener);
        nightfood.setOnClickListener(btnClickListener);
        zzim.setOnClickListener(btnClickListener);
        tosirak.setOnClickListener(btnClickListener);
        fastfood.setOnClickListener(btnClickListener);
        franchise.setOnClickListener(btnClickListener);
        ranking.setOnClickListener(btnClickListener);


        btn_login = (Button)(navigationView.getHeaderView(0).findViewById(R.id.btn_login));
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subMainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_process.login_process = null; //로그아웃
                login_check();
            }
        });

    }

    public static void login_check() { //로그인 판단
        if(Login_process.login_process == null) {
            logout.setVisibility(View.GONE);
            btn_login.setVisibility(View.VISIBLE);
            nick.setText("회원가입해줘요!");
        } else {
            logout.setVisibility(View.VISIBLE);
            btn_login.setVisibility(View.GONE);
            nick.setText(Login_process.login_process + "님 식사하세요.");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) { // 네비게이션메뉴 하단 버튼 부분 (미개발영역)
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
