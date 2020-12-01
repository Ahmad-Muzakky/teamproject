package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class product extends AppCompatActivity {

    private Button btnMinus1,btnAdd1,btnMinus2,btnAdd2,btnMinus3,btnAdd3,btnPesanan,btnMinus4,btnAdd4;
    private TextView tvItem1,tvJumlah1,tvItem2,tvJumlah2,tvItem3,tvJumlah3,tvItem4,tvJumlah4;
    model shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        shared = (model) this.getApplication();

        addproduct();
        btnPesanan = findViewById(R.id.btnPesanan);
        btnMinus1 = findViewById(R.id.btnMinus1);
        btnAdd1 = findViewById(R.id.btnAdd1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnAdd2  = findViewById(R.id.btnAdd2);
        btnMinus3 = findViewById(R.id.btnMinus3);
        btnAdd3  = findViewById(R.id.btnAdd3);
        btnMinus4 = findViewById(R.id.btnMinus4);
        btnAdd4  = findViewById(R.id.btnAdd4);
        tvItem1 = findViewById(R.id.tvItem1);
        tvJumlah1 = findViewById(R.id.tvJumlah1);
        tvItem2 = findViewById(R.id.tvItem2);
        tvJumlah2 = findViewById(R.id.tvJumlah2);
        tvItem3 = findViewById(R.id.tvItem3);
        tvJumlah3 = findViewById(R.id.tvJumlah3);
        tvItem4 = findViewById(R.id.tvItem4);
        tvJumlah4 = findViewById(R.id.tvJumlah4);

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnMinus1){

                    Integer vjumlah = shared.getJumlah1();
                    if(vjumlah>0){
                        vjumlah = vjumlah - 1;
                        shared.setJumlah1(vjumlah);
                    }
                    tvJumlah1.setText(vjumlah.toString());
                }
            }
        });
        btnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnMinus2){

                    Integer vjumlah = shared.getJumlah2();
                    if(vjumlah>0){
                        vjumlah = vjumlah - 1;
                        shared.setJumlah2(vjumlah);
                    }
                    tvJumlah2.setText(vjumlah.toString());
                }
            }
        });
        btnMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnMinus3){

                    Integer vjumlah = shared.getJumlah3();
                    if(vjumlah>0){
                        vjumlah = vjumlah - 1;
                        shared.setJumlah3(vjumlah);
                    }
                    tvJumlah3.setText(vjumlah.toString());
                }
            }
        });
        btnMinus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnMinus4){

                    Integer vjumlah = shared.getJumlah4();
                    if(vjumlah>0){
                        vjumlah = vjumlah - 1;
                        shared.setJumlah4(vjumlah);
                    }
                    tvJumlah4.setText(vjumlah.toString());
                }
            }
        });
        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnAdd1){

                    Integer vjumlah = shared.getJumlah1();

                    vjumlah = vjumlah + 1;
                    shared.setJumlah1(vjumlah);

                    tvJumlah1.setText(vjumlah.toString());
                }
            }
        });
        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnAdd2){

                    Integer vjumlah = shared.getJumlah2();

                    vjumlah = vjumlah + 1;
                    shared.setJumlah2(vjumlah);

                    tvJumlah2.setText(vjumlah.toString());
                }
            }
        });
        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnAdd3){

                    Integer vjumlah = shared.getJumlah3();

                    vjumlah = vjumlah + 1;
                    shared.setJumlah3(vjumlah);

                    tvJumlah3.setText(vjumlah.toString());
                }
            }
        });
        btnAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnAdd4){

                    Integer vjumlah = shared.getJumlah4();

                    vjumlah = vjumlah + 1;
                    shared.setJumlah4(vjumlah);

                    tvJumlah4.setText(vjumlah.toString());
                }
            }
        });
        btnPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnPesanan){
                    startActivity(new Intent(product.this, order.class));
                }
            }
        });
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
