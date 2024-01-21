package com.example.textinputedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText userName, userPassword;
    Button regisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextInputEditText) findViewById(R.id.userName);
        userPassword = (TextInputEditText) findViewById(R.id.userPassword);
        regisButton = (Button) findViewById(R.id.regisButton);
        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               register();
            }
        });
    }

    public void register() {
        String userStr = userName.getText().toString().trim();
        String passStr = userPassword.getText().toString().trim();
        if (checkUserName(userStr) && checkPassword(passStr)) {
            Toast.makeText(this,"You have been Registerd !",

                    Toast.LENGTH_SHORT).show();

        }
    }

    private boolean checkUserName(String name) {
        if (TextUtils.isEmpty(name) ) {
            userName.setError("Please enter a username");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String password) {
        if (TextUtils.isEmpty(password)) {
            userPassword.setError("Please enter a password");
            return false;
        }
        else if (password.length() < 6 ) {
            userPassword.setError("Password should be grater than 5 character");
            return false;
        }
        return true;
    }
}