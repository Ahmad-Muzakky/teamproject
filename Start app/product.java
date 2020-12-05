package com.example.mobileprogproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class product extends AppCompatActivity {

    RecyclerView recyclerView;
    Button orderbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        orderbtn = (Button) findViewById(R.id.orderbtn);
        recyclerView  = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView navbar = findViewById(R.id.bottom_navigation);
        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.product:
                        return true;
                    case R.id.chart:
                        startActivity(new Intent(getApplicationContext(),order.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });


        model[] list = new model[]{
                new model("Iphone",R.drawable.iphone,3000000),
                new model("Samsung",R.drawable.samsung,2000000),
                new model("Xiaomi",R.drawable.xiaomi,1200000),
                new model("Oppo",R.drawable.oppo, 1000000),
        };
        MainAdapter Adapter = new MainAdapter(list, product.this);
        recyclerView.setAdapter(Adapter);
    }
    private void openorder() {
        Intent intent = new Intent(this,order.class);
        startActivity(intent);
    }
}
