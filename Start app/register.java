package com.example.mobileprogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    private Button reg;
    private EditText user,pass,passreg,con;
    String isipass,conpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = (EditText) findViewById(R.id.userreg);
        passreg = (EditText) findViewById(R.id.passreg);
        isipass = passreg.getText().toString();
        con = (EditText) findViewById(R.id.conreg);
        conpass = con.getText().toString();
        reg = (Button) findViewById(R.id.regreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
    }
    public void nextpage(){
        if(user.length()<5 || user.length()>20){
            Toast.makeText(register.this,"Username Must be between 5 - 20",Toast.LENGTH_SHORT).show();
        }else if(passreg.length()<8){
            Toast.makeText(register.this,"password Must be more than 8 character",Toast.LENGTH_SHORT).show();
        }
//        else if (conpass.equals(isipass)){
//            Toast.makeText(register.this,"password Must be same",Toast.LENGTH_SHORT).show();
//        }
        else{
            Intent intent = new Intent(this,login.class);
            startActivity(intent);
        }
    }
}