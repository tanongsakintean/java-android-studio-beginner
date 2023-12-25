package com.example.eventmanagementapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnType1 = (Button) findViewById(R.id.btnType1);
        btnType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Event type 1 : Use inner class",Toast.LENGTH_LONG).show();
            }
        });
//        Button btnType2 = (Button) findViewById(R.id.btnType2);
        Button btnType3 = (Button) findViewById(R.id.btnType3);
        btnType3.setOnClickListener(this);

        Button btnType4 = (Button) findViewById(R.id.btnType4);
        btnType4.setOnClickListener(this);
    }

    public void  buttonClick2(View v){
        Toast.makeText(this,"Event type 2 : Use attribute onClick",Toast.LENGTH_LONG).show();
    }

    public  void onClick(View v){
        if(v.getId()==R.id.btnType3) {
            Toast.makeText(this, "Event type 3 : Use implement", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Event type 4 : Use implement", Toast.LENGTH_LONG).show();
        }
    }
}