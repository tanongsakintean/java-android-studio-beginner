package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> adapter;
    String [] datas = {"Arjun", "Ankit", "Arvind","Dipesh","Dinesh","Deven",

            "Java","Jeniva","Test","Thailand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>( this,

                android.R.layout.simple_list_item_1, datas);

        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}