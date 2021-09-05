package com.miniproject.griet_chef;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView tv10,tv11,tv12,tv15;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        tv10 = findViewById(R.id.order_id);
        tv11 = findViewById(R.id.cust_id);
        tv12 = findViewById(R.id.order);
        tv15 = findViewById(R.id.total);
        Intent kl = getIntent();

        String order_id = kl.getStringExtra("OID");
        String cust_id = kl.getStringExtra("CID");
        String dishes = kl.getStringExtra("OLIST");
        String total = kl.getStringExtra("TQ");


        tv10.setText("ORDER ID: "+ order_id);
        tv11.setText("CUSTOMER : "+cust_id);
        tv12.setText(dishes);
        tv15.setText("TOTAL NO OF ITEMS ORDERED: "+total);

    }
}
