package com.example.hellologcatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    private final String TAG = "MY_APP";
    private  int data = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnError = (Button) findViewById(R.id.btnError);
        btnError.setOnClickListener(this);


        Button btnWarning = (Button) findViewById(R.id.btnWarning);
        btnWarning.setOnClickListener(this);



        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);



        Button btnDebug = (Button) findViewById(R.id.btnDebug);
        btnDebug.setOnClickListener(this);



        Button btnVerbose = (Button) findViewById(R.id.btnVerbose);
        btnVerbose.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    if(v.getId() == R.id.btnError){
        Toast.makeText(MainActivity.this,"Show Logcat Error",Toast.LENGTH_LONG).show();
        Log.e(TAG, "Test log.e data = "+data );
    }else if(v.getId() == R.id.btnWarning){

        Toast.makeText(MainActivity.this,"Show Logcat Warning",Toast.LENGTH_LONG).show();
        Log.w(TAG, "Test log.w data = "+data );

    } else if (v.getId() == R.id.btnInfo) {
        Toast.makeText(MainActivity.this,"Show Logcat Information",Toast.LENGTH_LONG).show();
        Log.i(TAG, "Test log.i data = "+data );

    } else if (v.getId() == R.id.btnDebug) {
        Toast.makeText(MainActivity.this,"Show Logcat Debug",Toast.LENGTH_LONG).show();
        Log.d(TAG, "Test log.d data = "+data );

    } else if (v.getId() == R.id.btnVerbose) {
        Toast.makeText(MainActivity.this,"Show Logcat Verbose",Toast.LENGTH_LONG).show();
        Log.v(TAG, "Test log.v data = "+data );

    }


    }
}