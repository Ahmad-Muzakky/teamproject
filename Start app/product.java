package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class product extends AppCompatActivity {

    model shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        shared = (model) this.getApplication();

        addproduct();
    }

    public void addproduct(){
        if (shared.getFlag() == null || shared.getFlag() == 1) {
            shared.setItem1("Iphone");
            shared.setHarga1(5000000);
            shared.setJumlah1(0);

            shared.setItem2("Samsung");
            shared.setHarga2(4000000);
            shared.setJumlah2(0);

            shared.setItem3("Xiaomi");
            shared.setHarga3(3000000);
            shared.setJumlah3(0);

            shared.setItem4("Oppo");
            shared.setHarga4(20000000);
            shared.setJumlah4(0);
        }
    }

}