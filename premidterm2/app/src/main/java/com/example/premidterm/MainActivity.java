package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnImage,btnFormData,btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PreMidTerm");

        btnImage = (Button) findViewById(R.id.btnImage);
        btnImage.setOnClickListener(this);


        btnFormData = (Button) findViewById(R.id.btnFormData);
        btnFormData.setOnClickListener(this);


        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            if(v.getId() == R.id.btnImage){
                Intent lunchImageActivity = new Intent(MainActivity.this,ImageActivity.class);
                startActivity(lunchImageActivity);
            } else if (v.getId() == R.id.btnFormData) {
                Intent lunchFormDataActivity = new Intent(MainActivity.this, formDataActivity.class);
                startActivity(lunchFormDataActivity);
            }else if (v.getId() == R.id.btnLogout) {
                finish();
            }
    }
}