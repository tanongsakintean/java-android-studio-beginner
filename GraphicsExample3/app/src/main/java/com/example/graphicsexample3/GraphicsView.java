package com.example.graphicsexample3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import androidx.annotation.NonNull;

public class GraphicsView extends View {
    private Paint p1, p2;
    private int color[] = {Color.RED, Color.GREEN, Color.BLUE };
    private int width = 1080, height = 1920;

    public GraphicsView(Context context) {
        super(context);

        p1 = new Paint();
        p1.setStyle(Paint.Style.FILL);
        p2 = new Paint();
        p2.setStyle(Paint.Style.STROKE);
        p2.setColor(Color.BLACK);
        p2.setStrokeWidth(5);
    }


    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        myRectangle(canvas);
        myArc(canvas);
        myCircle(canvas);
    }

    public void myRectangle (Canvas canvas) {
        for(int n = 0; n < 3 ; n++) {
            int sizeX = 250, sizeY = 100 ;
            p1.setColor( color[n]);
            canvas.drawRect( 50, (n*sizeY), 50+sizeX, (n+1)*sizeY, p1);
            canvas.drawRect( 400,(n*sizeY),400+sizeX, (n+1)*sizeY, p1);
            canvas.drawRect( 750,(n*sizeY),750+sizeX, (n+1)*sizeY, p2);
        }
    }

    public void myArc (Canvas canvas) {
        canvas.drawArc(50,500,200,700,0,90,true,p1);
        canvas.drawArc(300,500,450,700,0,180,true,p1);
        RectF rect = new RectF(550,500,700,700);
        canvas.drawArc( rect, 0,180,true,p2 );
        canvas.drawArc( rect, 0,-180,true,p2 );
    }


    public void myCircle (Canvas canvas) {
        for(int n = 0; n < 3 ; n++) {
            p1.setStyle(Paint.Style.FILL);
            p1.setColor( color[n]);
            canvas.drawCircle( (n+1) * 250, 900 , 80 , p1);
            canvas.drawCircle( (n+1) * 250, 900 , 80 , p2);
        }
    }


}
