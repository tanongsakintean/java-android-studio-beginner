package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( new GraphicsView(this));
    }
}