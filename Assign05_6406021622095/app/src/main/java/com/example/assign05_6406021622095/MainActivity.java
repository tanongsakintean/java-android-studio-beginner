package com.example.assign05_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    RelativeLayout relativeLayout;
//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        Intent calculatorActivity = new Intent(MainActivity.this,calculatorActivity.class);
        Intent matchingGameActivity = new Intent(MainActivity.this,matchingGameActivity.class);

        if(item.getItemId() == R.id.exit) finishAffinity();
        if(item.getItemId() == R.id.calculator) startActivity(calculatorActivity);
        if(item.getItemId() == R.id.matchingGame) startActivity(matchingGameActivity);
       return true;
    }
}