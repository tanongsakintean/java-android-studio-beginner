package com.example.checkboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox appleCheckBox,bananaCheckBox,orangeCheckBox,grapeCheckBox;
    Button btnSubmit;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.show);
        appleCheckBox = (CheckBox) findViewById(R.id.appleCheckBox);
        bananaCheckBox = (CheckBox) findViewById(R.id.bananaCheckBox);
        orangeCheckBox = (CheckBox) findViewById(R.id.orangeCheckBox);
        grapeCheckBox = (CheckBox) findViewById(R.id.grapeCheckBox);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       String message = ""  ;
        message+= (appleCheckBox.isChecked()) ? "Select Apple \n" : "No select CheckBox 1\n";
        message+= (bananaCheckBox.isChecked()) ? "Select Banana \n" : "No select CheckBox 2\n";
        message+= (grapeCheckBox.isChecked()) ? "Select Grape \n" : "No select CheckBox 3\n";
        message+= (orangeCheckBox.isChecked()) ? "Select Orange \n" : "No select CheckBox 4\n";
        show.setText(message);

    }

}