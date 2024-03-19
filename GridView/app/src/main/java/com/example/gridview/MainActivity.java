package com.example.gridview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;
    String [] items = {

            "arsenal", "chelsea", "leicester", "liverpool",
            "manchester_city", "manchester_united"
    };
    Integer [] logo = {

            R.drawable.arsenal_logo, R.drawable.chelsea_logo,
            R.drawable.leicester_logo, R.drawable.liverpool_logo,
            R.drawable.manchester_city_logo,
            R.drawable.manchester_united_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter customAdapter = new CustomAdapter(this,items,logo);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemView = (String) gridView.getItemAtPosition(position);
        Toast.makeText(this, itemView, Toast.LENGTH_SHORT).show();
    }
}

class CustomAdapter extends ArrayAdapter<String> {
    private  final  Context context;
    private  final  String[] items;
    private  final  Integer[] logos;

    public CustomAdapter( Context context,  String[] items, Integer[] logos) {
        super(context,R.layout.custom_layout, items);
        this.context = context;
        this.items = items;
        this.logos = logos;
    }

    @Override
    public View getView(int position, View view , ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_layout,null,true);
        TextView title = (TextView)  rowView.findViewById(R.id.textView);
        ImageView image = (ImageView)  rowView.findViewById(R.id.imageView);
        title.setText(items[position]);
        image.setImageResource(logos[position]);
        return rowView;

    }
}