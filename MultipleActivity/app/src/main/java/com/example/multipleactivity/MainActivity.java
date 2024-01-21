package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button firstBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBtn = (Button) findViewById(R.id.button1);
        firstBtn.setOnClickListener(this);
        exitBtn = (Button) findViewById(R.id.button2);
        exitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1) {
            Toast.makeText( this,"Call FirstActivity", Toast.LENGTH_SHORT).show();
            Intent launchFirst = new Intent( this, FirstActivity.class);
            startActivity(launchFirst); // call FirstActivity
        }
        else if (id == R.id.button2) {
            Toast.makeText( this,"Exit Main Activity", Toast.LENGTH_SHORT).show();
            finish(); // exit app
        }
    }
}