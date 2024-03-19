package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAutoComplete(View view) {
        Intent autoComplete = new Intent(MainActivity.this,AutoComplete.class);
        startActivity(autoComplete);
    }

    public void openTextSwitcher(View view) {
        Intent textSwitcher = new Intent(MainActivity.this,TextSwicther.class);
        startActivity(textSwitcher);
    }

    public void openAdapterFipper(View view) {
        Intent adapterFipper = new Intent(MainActivity.this,AdapterViewFipper.class);
        startActivity(adapterFipper);
    }

    public void openScrollView(View view) {
        Intent scrollView = new Intent(MainActivity.this,ScrollViews.class);
        startActivity(scrollView);
    }

    public void openImageSwitcher(View view) {
        Intent imageSwitcher= new Intent(MainActivity.this,ImageSwitchers.class);
        startActivity(imageSwitcher);
    }

    public void openStackView(View view) {
        Intent stackView = new Intent(MainActivity.this,StackViews.class);
        startActivity(stackView);
    }
}