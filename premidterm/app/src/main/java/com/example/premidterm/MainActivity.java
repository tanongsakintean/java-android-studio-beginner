package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCale,btnVat,btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mid/65");


        Button btnCale = (Button) findViewById(R.id.btnCale);
        btnCale.setOnClickListener(this);

        Button btnVat = (Button) findViewById(R.id.btnVat);
        btnVat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCale){
            Intent lunchCale = new Intent(MainActivity.this,calculatorGrade.class);
            startActivity(lunchCale);
        } else if (v.getId() == R.id.btnVat) {
            Intent lunchVat = new Intent(MainActivity.this, vator.class);
            startActivity(lunchVat);
        }
    }
}