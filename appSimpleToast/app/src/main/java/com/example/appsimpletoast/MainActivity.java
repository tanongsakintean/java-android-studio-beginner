package com.example.appsimpletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Toast toast;
    RadioButton radioTop, radioLeft, radioCenter, radioRight, radioBottom;
    Button btn;
    EditText textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GradientDrawable gd = new GradientDrawable();
        gd.setStroke( 3, Color.RED);
        gd.setColor(Color.LTGRAY);
        gd.setCornerRadius( 30);
        textName = (EditText) findViewById(R.id.textName);
        textName.setBackground( gd);
        toast = Toast.makeText(this,"This simple Toast",Toast.LENGTH_SHORT);
        radioTop = (RadioButton) findViewById(R.id.radioTop);
        radioLeft = (RadioButton) findViewById(R.id.radioLeft);
        radioCenter = (RadioButton) findViewById(R.id.radioCenter);
        radioRight = (RadioButton) findViewById(R.id.radioRight);
        radioBottom = (RadioButton) findViewById(R.id.radioBottom);
        btn = (Button) findViewById(R.id.btnToast);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = "";
        name = textName.getText().toString().trim();
        if (radioTop.isChecked()) {
            toast.setText("Display Top, Hello "+name);
            toast.setGravity(Gravity.TOP, 50, 0);
        }
        else if (radioLeft.isChecked()) {
            toast.setText("Display Left, Hello " +name);
            toast.setGravity(Gravity.LEFT, 0, 0);
        }
        else if (radioCenter.isChecked()) {
            toast.setText("Display Center, Hello "+name);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        else if (radioRight.isChecked()) {
            toast.setText("Display Right, Hello "+name);
            toast.setGravity(Gravity.RIGHT, 0, 0);
        }
        else if (radioBottom.isChecked()) {
            toast.setText("Display Bottom, Hello "+name);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        toast.show();
    }
}