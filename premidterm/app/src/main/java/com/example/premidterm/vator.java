package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class vator extends AppCompatActivity implements View.OnClickListener {
    Button btnVatBack,btnSubmitVat;
    EditText inputSalary,inputLife,inputHome;
    RadioButton radioButton0,radioButton1,radioButton2;

    TextView resultVat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vator);

        btnVatBack = (Button) findViewById(R.id.btnVatBack);
        btnVatBack.setOnClickListener(this);

        btnSubmitVat = (Button) findViewById(R.id.btnSubmitVat);
        btnSubmitVat.setOnClickListener(this);

        inputHome = (EditText) findViewById(R.id.inputHome);
        inputLife = (EditText) findViewById(R.id.inputLife);
        inputSalary = (EditText) findViewById(R.id.inputSalary);

       resultVat = (TextView) findViewById(R.id.resultVat);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnVatBack){
            finish();
        }else if (v.getId() == R.id.btnSubmitVat){

        }
    }
}