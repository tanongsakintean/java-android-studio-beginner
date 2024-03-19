package com.example.graphicsexample2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }
}

class GraphicsView extends View{
    int width = 1080;
    int height = 1920;

    public GraphicsView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw( Canvas canvas) {
        Paint p1 = new Paint();
        p1.setColor(Color.GREEN);
        p1.setStyle(Paint.Style.FILL);
        canvas.drawRect(width/2 - 250,100,width/2+250,600,p1);
        p1.setColor(Color.BLACK);
        p1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width/2,350,150,p1);
        canvas.drawCircle(width/2,350,200,p1);
        canvas.drawCircle(width/2,350,250,p1);

        Paint p2 = new Paint();
        p2.setColor( Color.argb(255, 255, 0, 255) );
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(5);
        canvas.drawRect(100, 70 , width - 100, 630, p2);
        canvas.drawRect(50, 30 , width -50, 670, p2);

        canvas.drawRect( 10, 800 , width -10, 900, p2);
        p1.setColor(Color.BLACK);
        p1.setAntiAlias(true);
        p1.setTextSize(40);
        p1.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Android", 100, 870, p1);
        p1.setTextAlign(Paint.Align.RIGHT);
        p1.setTextSize(50);
        canvas.drawText("Programming", 1000, 870, p1);
        p1.setTextAlign(Paint.Align.CENTER);
        p1.setColor(Color.BLUE);
        int size = 10;
        for (int n = 0 ; n < 6 ; n++) {
            p1.setTextSize(size);
            canvas.drawText("Android", width/2, 1000+(n*size+40),p1);
            size += 10;
        }
    }
}