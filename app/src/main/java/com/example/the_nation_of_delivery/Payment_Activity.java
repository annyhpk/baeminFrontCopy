package com.example.the_nation_of_delivery;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Payment_Activity extends AppCompatActivity {

    Button pay_ok;
    TextView pay_change, pay_method, pay1, pay2;
    CheckBox cash;
    LinearLayout cash_layout;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        price = getIntent().getExtras().getString("price");

        pay_ok = findViewById(R.id.btn_pay);
        pay_change = findViewById(R.id.payment_change);
        pay_method = findViewById(R.id.payment_method);
        cash = findViewById(R.id.cash);
        cash_layout = findViewById(R.id.cash_layout);
        pay1 = findViewById(R.id.pay_cash);
        pay2 = findViewById(R.id.pay_cash2);

        pay1.setText(price+"원");
        pay2.setText("주문금액 "+ price +"원 + 배달팁 2,000원");
        pay_ok.setText(price+"원 결제하기");


        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    cash_layout.setVisibility(View.VISIBLE);
                } else {
                    cash_layout.setVisibility(View.GONE);
                }
            }
        });

                pay_change.setClickable(true);
        pay_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        pay_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast toast = Toast.makeText(Payment_Activity.this, price + "원 결제가 완료되었습니다. "
                                                                     + "50분뒤에 배달이 완료됩니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void show()
    {
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("카드 결제");
        ListItems.add("카카오 페이");
        ListItems.add("배민 페이");
        ListItems.add("만나서 결제");
        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결제 방법");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int pos) {
                String selectedText = items[pos].toString();
                pay_method.setText(selectedText);
            }
        });
        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
