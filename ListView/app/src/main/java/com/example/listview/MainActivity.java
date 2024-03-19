package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    ListView listView;
    String [] items = {
            "Bitcoin","Ethereum","LiteCoin","Dash","Neo","Nano","Bitcoin Cash",
            "Verge","Pipple","Bitcoin diamond","Iconomi","Stellar Lumens"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        int itemPos = position;
        String itemValue = (String) listView.getItemAtPosition(itemPos);
        Toast.makeText(this,

                "Position: "+itemPos + " Item clicked : "+itemValue,

                Toast.LENGTH_SHORT).show();
    }
}