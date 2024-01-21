package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ShowImage extends AppCompatActivity implements View.OnClickListener{
    int[] imgBtn = {R.id.amounus,R.id.blue,R.id.spderman,R.id.tom,R.id.jerry,R.id.pikashu,R.id.shark,R.id.person};
    int[] Images = {R.mipmap.amountus,R.mipmap.blue,R.mipmap.spiderman,R.mipmap.tom,R.mipmap.jerry,R.mipmap.pikashu,R.mipmap.shark,R.mipmap.person};
    ImageButton[] btnIMG;
    ImageView showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        btnIMG = new ImageButton[imgBtn.length];

        for (int i = 0; i < imgBtn.length ; i++) {
            btnIMG[i] = (ImageButton) findViewById(imgBtn[i]);
            btnIMG[i].setOnClickListener(this);
        }


        showImage = (ImageView) findViewById(R.id.showImage);
        showImage.setImageResource(R.mipmap.amountus);


    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < imgBtn.length ; i++) {
            if (v.getId() == imgBtn[i]) {
                showImage.setImageResource(Images[i]);
                break;
            }
        }
    }
}