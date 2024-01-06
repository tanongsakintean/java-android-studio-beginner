package com.example.changebasenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText num;
    private TextView decNumber;
    private TextView binaryNumber;
    private TextView octalNumber;
    private TextView hexaNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText) findViewById(R.id.num);
        decNumber = (TextView) findViewById(R.id.decNumber);
        binaryNumber = (TextView) findViewById(R.id.binaryNumber);
        octalNumber = (TextView) findViewById(R.id.octalNumber);
        hexaNumber = (TextView) findViewById(R.id.hexaNumber);


    }

    public void onClickCalculate(View v){
        if(num.getText().toString().isEmpty()){
            Toast.makeText(this,"Field Not Empty! ",Toast.LENGTH_LONG).show();
        }else{
                decNumber.setText(num.getText().toString());
                binaryNumber.setText(Integer.toBinaryString(Integer.parseInt(num.getText().toString())));
                octalNumber.setText(Integer.toOctalString(Integer.parseInt(num.getText().toString())));
                hexaNumber.setText(Integer.toHexString(Integer.parseInt(num.getText().toString())));
        }
//        Integer.toBinaryString(10)
//        Integer.toOctalString(8)
//        Integer.toHexString(10)
    }
}