package com.example.radiobuttonapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
   private LinearLayout linearLayout;
   private RadioGroup colorGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorGroup = (RadioGroup) findViewById(R.id.colorGroup);
        colorGroup.setOnCheckedChangeListener(this);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.redRadio) linearLayout.setBackgroundColor(Color.RED);
        if(checkedId == R.id.greenRadio) linearLayout.setBackgroundColor(Color.GREEN);
        if(checkedId == R.id.blueRadio) linearLayout.setBackgroundColor(Color.BLUE);
        if(checkedId == R.id.whiteRadio) linearLayout.setBackgroundColor(Color.WHITE);
    }
}