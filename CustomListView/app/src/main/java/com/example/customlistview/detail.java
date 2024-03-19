package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class detail extends AppCompatActivity {
    String title;
    Integer imageId;

    TextView textDetail;
    ImageView imageDetail;


    Integer [] logos = {

            R.drawable.arsenal_logo,R.drawable.chelsea_logo,
            R.drawable.leicester_logo,R.drawable.liverpool_logo,
            R.drawable.manchester_city_logo,
            R.drawable.manchester_united_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        title =  intent.getStringExtra("title");
        imageId = intent.getIntExtra("imageId",0);

        textDetail = (TextView) findViewById(R.id.textDetail);
        textDetail.setText(title);

        imageDetail = (ImageView) findViewById(R.id.imgeDetail);
        imageDetail.setImageResource(logos[imageId]);

    }

}