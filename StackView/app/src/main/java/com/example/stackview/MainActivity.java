package com.example.stackview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackView = (StackView) findViewById(R.id.stackView);
        stackView.setInAnimation(this, android.R.animator.fade_in);
        stackView.setOutAnimation(this, android.R.animator.fade_out);
        StackViewAdapter alboumAdaper = new StackViewAdapter(MainActivity.this,R.layout.item,getStores());
        stackView.setAdapter(alboumAdaper);
    }

    private List<String> getStores(){
        List<String> stores = new ArrayList<String>();
        stores.add("deosai_land");
        stores.add("dudipatsar_lake");
        stores.add("rama_lake");
        stores.add("shangrila_lower_kachura_lake");
        return stores;
    }

}

