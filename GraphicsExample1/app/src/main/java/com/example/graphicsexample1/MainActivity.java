package com.example.graphicsexample1;

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
        setContentView( new GraphicsView (this) );
    }


    static public class GraphicsView extends View {
        public GraphicsView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {

            Paint p1 = new Paint();
            p1.setColor(Color.RED);
            p1.setAlpha(255);
            p1.setStyle(Paint.Style.FILL);
            Paint p2 = new Paint();
            p2.setColor(Color.GREEN);
            p2.setAlpha(255);
            p2.setStyle(Paint.Style.FILL);
            Paint p3 = new Paint();
            p3.setColor(Color.BLUE);
            p3.setAlpha(255);
            p3.setStyle(Paint.Style.FILL);

// draw rectangle
            canvas.drawRect(50, 50 , 250, 250, p1);

            canvas.drawRect(300, 50 , 500, 250, p2);
            canvas.drawRect(550, 50 , 750, 250, p3);

// draw line
            canvas.drawLine(20, 400, 800, 400, p1);
            p2.setStrokeWidth(3);
            canvas.drawLine(20, 450, 800, 450, p2);
            p3.setStrokeWidth(5);
            canvas.drawLine(20, 500, 800, 500, p3);

// draw circle
            p1.setAlpha(100);
            canvas.drawCircle(100, 750 , 50, p2);
            canvas.drawCircle(100, 750, 100, p1);
            canvas.drawCircle(500, 750 , 50, p3);
            canvas.drawCircle(500, 750, 100, p1);
        }
    }
}