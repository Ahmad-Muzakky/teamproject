package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity {
    private TextView orderitem,orderjumlah,orderharga,ordertotal;
    private Button pay;
    model shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        shared = (model) this.getApplication();
        orderitem = findViewById(R.id.orderitem);
        orderjumlah = findViewById(R.id.orderjumlah);
        orderharga = findViewById(R.id.orderharga);
        ordertotal = findViewById(R.id.ordertotal);
        pay = findViewById(R.id.bttnpay);

        Integer Total = 0;

        Total = Total + (shared.getJumlah1() * shared.getHarga1());
        Total = Total + (shared.getJumlah2() * shared.getHarga2());
        Total = Total + (shared.getJumlah3() * shared.getHarga3());
        Total = Total + (shared.getJumlah4() * shared.getHarga4());

        ordertotal.setText("Rp. "+Total.toString());

        String Item = "Item\n";

        if (shared.getJumlah1() > 0) Item = Item + shared.getItem1() + " - " +"Rp. "+ shared.getHarga1().toString() + "\n";
        if (shared.getJumlah2() > 0) Item = Item + shared.getItem2() + " - " +"Rp. "+ shared.getHarga2().toString() + "\n";
        if (shared.getJumlah3() > 0) Item = Item + shared.getItem3() + " - " +"Rp. "+ shared.getHarga3().toString() + "\n";
        if (shared.getJumlah4() > 0) Item = Item + shared.getItem4() + " - " +"Rp. "+ shared.getHarga4().toString() + "\n";

        orderitem.setText(Item);

        String Jumlah = "Jumlah\n";

        if (shared.getJumlah1() > 0) Jumlah = Jumlah + shared.getJumlah1() + "\n";
        if (shared.getJumlah2() > 0) Jumlah = Jumlah + shared.getJumlah2() + "\n";
        if (shared.getJumlah3() > 0) Jumlah = Jumlah + shared.getJumlah3() + "\n";
        if (shared.getJumlah4() > 0) Jumlah = Jumlah + shared.getJumlah4() + "\n";

        orderjumlah.setText(Jumlah);

        String Harga = "Harga\n";
        if (shared.getJumlah1() > 0) Harga = Harga +"Rp. "+ shared.getHarga1()*shared.getJumlah1() + "\n";
        if (shared.getJumlah2() > 0) Harga = Harga +"Rp. "+ shared.getHarga2()*shared.getJumlah2() + "\n";
        if (shared.getJumlah3() > 0) Harga = Harga +"Rp. "+ shared.getHarga3()*shared.getJumlah3() + "\n";
        if (shared.getJumlah4() > 0) Harga = Harga +"Rp. "+ shared.getHarga4()*shared.getJumlah4() + "\n";
        orderharga.setText(Harga);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == pay){
                    Toast.makeText(order.this, "Your Order Complete Thank You", Toast.LENGTH_SHORT).show();
                    shared.setFlag(1);
                    startActivity(new Intent(order.this, MainActivity.class));
                }
            }
        });

    }

}