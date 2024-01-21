package com.example.switchtoggleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ToggleButton toggleButton1, toggleButton2;
    Switch wifiSwitch,bluetoothSwitch;
    Button btnOk ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        wifiSwitch = (Switch) findViewById(R.id.wifiSwitch);
        bluetoothSwitch = (Switch) findViewById(R.id.bluetoothSwitch);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

    }

    public void onClickToggle(View view) {
        String message = "";
        if(view.getId() == R.id.toggleButton1) message = (toggleButton1.isChecked()) ? "WiFi toggle 1 ON!" : "Wifi Toggle 1 OFF!";
        if(view.getId() == R.id.toggleButton2) message = (toggleButton2.isChecked()) ? "Bluetooth toggle 2 ON!" : "Bluetooth Toggle 2 OFF!";
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void onClickSwitch(View view) {
        String message = "";
        if(view.getId() == R.id.wifiSwitch) message = (wifiSwitch.isChecked()) ? "WiFi Switch 1 ON!" : "Wifi Switch 1 OFF!";
        if(view.getId() == R.id.bluetoothSwitch) message = (bluetoothSwitch.isChecked()) ? "Bluetooth Switch 2 ON!" : "Bluetooth Switch 2 OFF!";
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String message = "WiFi ";
        message += ( wifiSwitch.isChecked()) ? "ON \n" : "OFF \n";
        message +=" Bluetooth ";
        message += ( bluetoothSwitch.isChecked()) ? "ON \n" : "OFF \n";
        message +=" WiFi Toggle 1 ";
        message += (toggleButton1.isChecked()) ? "ON \n" : "OFF \n";
        message +=" Bluetooth Toggle 1 ";
        message += (toggleButton2.isChecked()) ? "ON \n" : "OFF \n";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}