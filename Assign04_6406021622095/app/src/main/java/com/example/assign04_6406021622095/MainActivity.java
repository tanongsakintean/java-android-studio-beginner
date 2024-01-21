package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGrade,btnVat,btnGPA,btnImage,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Assignment 2");

        btnGrade = (Button) findViewById(R.id.btnGrade);
        btnGrade.setOnClickListener(this);

        btnVat = (Button) findViewById(R.id.btnVat);
        btnVat.setOnClickListener(this);

        btnGPA = (Button) findViewById(R.id.btnGPA);
        btnGPA.setOnClickListener(this);

        btnImage = (Button) findViewById(R.id.btnImage);
        btnImage.setOnClickListener(this);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnBack) {
            finish();
        } else if (v.getId() == R.id.btnGrade) {
            Intent lunchGrade = new Intent(MainActivity.this,CalculateGrade.class) ;
            startActivity(lunchGrade);
        } else if (v.getId()  == R.id.btnVat) {
            Intent lunchVat = new Intent(MainActivity.this,CalculateVat.class) ;
            startActivity(lunchVat);
        } else if (v.getId() == R.id.btnGPA) {
            Intent lunchGPA = new Intent(MainActivity.this,CalculateGPA.class) ;
            startActivity(lunchGPA);
        } else if (v.getId() == R.id.btnImage) {
            Intent lunchImage = new Intent(MainActivity.this,ShowImage.class) ;
            startActivity(lunchImage);
        }

    }
}