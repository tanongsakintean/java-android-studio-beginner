package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity  {
   public int[] images = {R.mipmap.img1_foreground,R.mipmap.img2_foreground,R.mipmap.img3_foreground,R.mipmap.img4_foreground,R.mipmap.img5_foreground,R.mipmap.img6_foreground,R.mipmap.img6_foreground,R.mipmap.img7_foreground,R.mipmap.img8_foreground};
   public int index = 0;
  public   ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = (ImageView) findViewById(R.id.imageView);


    }

    public void onNextImage(View view) {
        if (++index == images.length) index = 0 ;
        imageView.setImageResource(images[index]);
    }

    public void onPrevImage(View view) {
        if (--index < 0) index = images.length - 1 ;
        imageView.setImageResource(images[index]);
    }

    public void goBack(View view) {
        finish();
    }
}