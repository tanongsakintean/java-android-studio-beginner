package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    LayoutInflater layoutInflater;
    View toastLayout;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutInflater = getLayoutInflater();
        toastLayout = layoutInflater.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.myCustomLayouts));
        btn = (Button) findViewById(R.id.btnCustom);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toastCustom;
        toastCustom = Toast.makeText(this,"My Custom Toast", Toast.LENGTH_SHORT);
        toastCustom.setGravity(Gravity.CENTER, 0, 0);
        toastCustom.setView( toastLayout );
        toastCustom.show();
    }
}