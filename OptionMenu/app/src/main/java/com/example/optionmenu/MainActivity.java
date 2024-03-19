package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        textView = (TextView) findViewById(R.id.textView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.profile) {
            relativeLayout.setBackgroundColor(Color.RED);
            textView.setText(item.getTitle());
            Toast.makeText(this, "Profile is Selected", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.settings) {
            relativeLayout.setBackgroundColor(Color.GREEN);
            textView.setText(item.getTitle());
            Toast.makeText(this, "Settings is Selected", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.exit) {
            relativeLayout.setBackgroundColor(Color.BLUE);
            textView.setText(item.getTitle());
            Toast.makeText(this, "Exit is Selected", Toast.LENGTH_SHORT).show();
            finish();
        }
            return super.onOptionsItemSelected(item);


    }
}