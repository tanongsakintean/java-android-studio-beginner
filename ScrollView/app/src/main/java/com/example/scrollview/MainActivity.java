package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private ImageView[] imagesView;
    private int [] resId = {
            R.drawable.pic1, R.drawable.pic2,R.drawable.pic3, R.drawable.pic4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        imagesView = new ImageView[4];
        for (int i = 0; i < imagesView.length ; i++) {
            imagesView[i] = new ImageView(this);
            imagesView[i].setId(25100+i);
            imagesView[i].setPadding(0,0,0,0);
            imagesView[i].setImageResource(resId[i]);
            imagesView[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
            imagesView[i].setOnClickListener(this);
            linearLayout.addView(imagesView[i]);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,""+v.getId(), Toast.LENGTH_SHORT).show();
    }
}