package com.example.changebasenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText num;
    private Button btnCal;
    private TextView decNumber;
    private TextView binaryNumber;
    private TextView octalNumber;
    private TextView hexaNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText) findViewById(R.id.num);
        btnCal = (Button) findViewById(R.id.btnCal);
        decNumber = (TextView) findViewById(R.id.decNumber);
        binaryNumber = (TextView) findViewById(R.id.binaryNumber);
        octalNumber = (TextView) findViewById(R.id.octalNumber);
        hexaNumber = (TextView) findViewById(R.id.hexaNumber);

       btnCal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d("start", "onClick: ");
           }
       });

    }
}