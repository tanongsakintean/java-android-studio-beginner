package com.example.testradiobuttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOk;
    RadioButton radioBtn1,radioBtn2,radioBtn3,radioBtn4,radioBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
        radioBtn1 = (RadioButton) findViewById(R.id.radioButton1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioButton2);
        radioBtn3 = (RadioButton) findViewById(R.id.radioButton3);
        radioBtn4 = (RadioButton) findViewById(R.id.radioButton4);
        radioBtn5 = (RadioButton) findViewById(R.id.radioButton5);
    }

    @Override
    public void onClick(View v) {
        String message = "";
       if(radioBtn1.isChecked()) message = radioBtn1.getText().toString();
       if(radioBtn2.isChecked()) message = radioBtn2.getText().toString();
       if(radioBtn3.isChecked()) message = radioBtn3.getText().toString();
       if(radioBtn4.isChecked()) message = radioBtn4.getText().toString();
       if(radioBtn5.isChecked()) message = radioBtn5.getText().toString();

    Toast.makeText(this, "You choice :"+message, Toast.LENGTH_SHORT).show();

    }
}