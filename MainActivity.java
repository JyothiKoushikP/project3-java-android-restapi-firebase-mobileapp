package com.miniproject.griet_chef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.title);
        b = findViewById(R.id.go);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this,BOOKINGS.class);
        startActivity(i);
    }
}
