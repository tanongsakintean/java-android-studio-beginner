package com.example.changedistanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText kiloText;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       kiloText = (EditText) findViewById(R.id.kiloText);
       btnCal = (Button) findViewById(R.id.btnCal);
       btnCal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               float kilo,mile;
               kilo = Integer.parseInt(kiloText.getText().toString());
               mile = kilo*5/8;
               Toast.makeText(MainActivity.this,mile+" miles.",Toast.LENGTH_LONG).show();
           }
       });
    }
}