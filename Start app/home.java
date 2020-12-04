package com.example.mobileprogproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class home extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.ip,R.drawable.sm,R.drawable.hp};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    model shared = new model();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initSlider();
        ButterKnife.bind(this);

        Button product = (Button) findViewById(R.id.homeproduct);
        Button lokasi = (Button) findViewById(R.id.homemylocation);
        Button order = (Button) findViewById(R.id.homemyorder);
        Button about = (Button) findViewById(R.id.homeabout);
        Button log = (Button) findViewById(R.id.logout);

        addproduct();
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
                nextpage4();
            }
        });
        lokasi.setOnClickListener(new View.OnClickListener() {
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

    private void initSlider() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new Imageslider(home.this, ImagesArray));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

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
    public void nextpage(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void nextpage1(){
        Intent intent = new Intent(this,product.class);
        startActivity(intent);
    }
    public void nextpage2(){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=-6.931547, 107.717056"));
        startActivity(intent);

    }
    public void nextpage3(){
        Intent intent = new Intent(this,about.class);
        startActivity(intent);
    }
    public void nextpage4(){
        Intent intent = new Intent(this,order.class);
        startActivity(intent);
    }
}
