package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
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
        textView = (TextView) findViewById(R.id.textView);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        registerForContextMenu(textView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose a Color");
        menu.add( "Yellow");
        menu.add( "Gray");
        menu.add( "Cyan");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Yellow") {
            relativeLayout.setBackgroundColor(Color.YELLOW);
            Toast.makeText(this,"You Select Yellow",Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "Gray") {
            relativeLayout.setBackgroundColor(Color.GRAY);
            Toast.makeText(this, "You Select Yellow", Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "Cyan") {
            relativeLayout.setBackgroundColor(Color.CYAN);
            Toast.makeText(this, "You Select Yellow", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}