package com.example.sum_min_max;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resultMax = (TextView) findViewById(R.id.resultMax);
        TextView resultMin = (TextView) findViewById(R.id.resultMin);
        TextView resultSum = (TextView) findViewById(R.id.resultSum);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1.getText().toString().matches("")  || num2.getText().toString().matches("")  ){
                    Toast.makeText(MainActivity.this,"Field Not Empty",Toast.LENGTH_LONG).show();
                }else{
                resultMax.setText(max(Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString())));
                resultMin.setText(min(Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString())));
                resultSum.setText(sum(Integer.parseInt(num1.getText().toString()),Integer.parseInt(num2.getText().toString())));
                }
            }
        });
    }

    protected String sum(Integer num1,Integer num2){
        int ans = Integer.sum(num1,num2);
        return Integer.toString(ans);
    }
    protected String min(Integer num1,Integer num2){
        int ans = Integer.min(num1,num2);
        return Integer.toString(ans);
    }
    protected String max(Integer num1,Integer num2){
        int ans = Integer.max(num1,num2);
        return Integer.toString(ans);
    }


}