package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Toast.makeText( this, "Welcome to First Activity", Toast.LENGTH_SHORT).show();
        backBtn = (Button) findViewById(R.id.backButton);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText( this, " Finish FirstActivity ",Toast.LENGTH_SHORT).show();
//        finishAffinity(); // exit program
        finish(); // exit FirstActivity
    }
}