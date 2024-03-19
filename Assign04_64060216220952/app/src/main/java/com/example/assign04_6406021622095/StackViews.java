package com.example.assign04_6406021622095;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StackViews extends AppCompatActivity {

    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_views);

        stackView = (StackView) findViewById(R.id.stackView);
        stackView.setInAnimation(this, android.R.animator.fade_in);
        stackView.setOutAnimation(this, android.R.animator.fade_out);
        StackViewAdapter alboumAdaper = new StackViewAdapter(StackViews.this,R.layout.item,getStores());
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

