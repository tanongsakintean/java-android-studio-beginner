package com.example.graphicsexample4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GraphicsView extends View {
    private Bitmap image;
    private Paint p1, p2;
    private int width = 1080, height = 1920;
    public GraphicsView(Context context) {
        super(context);
        p1 = new Paint();
        p1.setTextAlign(Paint.Align.CENTER);
        p1.setTextSize(60);
        p2 = new Paint();
        p2.setStyle(Paint.Style.STROKE);
        p2.setColor(Color.BLACK);
        p2.setStrokeWidth(5);
        image = BitmapFactory.decodeResource( getResources(),

                com.google.android.material.R.drawable.abc_cab_background_top_mtrl_alpha);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        p1.setColor(Color.BLACK);
        canvas.drawText( "Test draw bitmap", width/2 , 65 , p1);
        p1.setColor(Color.GREEN);
        canvas.drawText( "Test draw bitmap", width/2 - 5, 60 , p1);
        canvas.drawRect(10, 10, width - 10, 100, p2);
// draw picture
        canvas.drawBitmap( image, 100, 200, p1);
        canvas.drawBitmap( image, 400, 200, p2);
        canvas.drawBitmap( image, 700, 200, null);
        int w = image.getWidth();
        int h = image.getHeight();
        int x, y;
        for (int n = 0; n < 5 ; n++) {
            x = n * w;
            y = n * h;
            canvas.drawBitmap( image, x, 500+ y, null);
        }
    }


}
