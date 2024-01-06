package com.example.exercise4_2s6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Button btnUp;
    Button btnDown;
    Button btnReset;
    EditText input;

    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnUp = (Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);
         btnDown = (Button) findViewById(R.id.btnDown);
        btnDown.setOnClickListener(this);
         btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(this);
         input = (EditText) findViewById(R.id.input);
        input.setText(count.toString());
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnUp){
            count++;
            if(count == 5){
                Toast.makeText(this,"ตัวเลขนี้หาร 5 ลงตัว",Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btnDown) {
            count--;
            if(count == 5){
                Toast.makeText(this,"ตัวเลขนี้หาร 5 ลงตัว",Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btnReset) {
            count = 0 ;
        }


        input.setText(count.toString());
    }
}