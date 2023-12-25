package com.example.basicloginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin,btnClear;
    EditText usernameText,passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnClear = (Button) findViewById(R.id.btnClear);

        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnClear){
            usernameText.setText("");
            passwordText.setText("");
        }else{
            String message = "";
            message+="username : "+usernameText.getText().toString();
            message+="\npassword : "+passwordText.getText().toString();
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
    }
}