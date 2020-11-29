package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button product = (Button) findViewById(R.id.homeproduct);
        Button order = (Button) findViewById(R.id.homemyorder);
        Button about = (Button) findViewById(R.id.homeabout);
        Button log = (Button) findViewById(R.id.logout);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage1();
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage2();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage3();
            }
        });
    }
    public void nextpage(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void nextpage1(){
        Intent intent = new Intent(this,product.class);
        startActivity(intent);
    }
    public void nextpage2(){
        Intent intent = new Intent(this,order.class);
        startActivity(intent);
    }
    public void nextpage3(){
        Intent intent = new Intent(this,about.class);
        startActivity(intent);
    }
}
