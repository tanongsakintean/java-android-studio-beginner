package com.example.assign06_6406021622095_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p1, p2,p3;
    private float x1, y1, x2, y2;

    private  int menuActive = 0;

    int sizeX = 250, sizeY = 100 ;
    private String title[] = {"LINE","RECTANGLE","CIRCLE","LINE"};

    private boolean isFirst = true;
    public GraphicsView(Context context)
    {
        super(context);
        p1 = new Paint();

        p2 = new Paint();
        p2.setStyle(Paint.Style.STROKE);
        p2.setColor(Color.BLACK);
        p2.setStrokeWidth(5);

        p3 = new Paint();
        p3.setStyle(Paint.Style.STROKE);
        p3.setColor(Color.RED);
        p3.setStrokeWidth(5);

        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // Get touch coordinates
        float touchX = event.getX();
        float touchY = event.getY();

        // Check if touch event is a click
        if (event.getAction() == MotionEvent.ACTION_UP) {
            // Iterate over rectangles and check if touch coordinates are inside any of them
            for (int n = 0; n < 4; n++) {
                int rectLeft = n * sizeX;
                int rectRight = rectLeft + sizeX;
                int rectTop = 0;
                int rectBottom = sizeY;

                // Check if touch coordinates are inside the current rectangle
                if (touchX >= rectLeft && touchX <= rectRight && touchY >= rectTop && touchY <= rectBottom) {
                    // Handle click event for this rectangle (replace this with your own logic)
                    if (n == 0) menuActive=0;
                    if (n==1) menuActive=1;
                    if (n==2) menuActive=2;
                    if (n==3) menuActive=3;
                    // Redraw the view
                }

            }

            if (isFirst) {
                x1 = event.getX();
                y1 = event.getY();
                isFirst=false;
            }
            else {
                x2 = event.getX();
                y2 = event.getY();
                isFirst = true;
            }


            invalidate();
        }

        return true;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        title[3] = title[menuActive];
        myMenu(canvas);
        if (menuActive==0) canvas.drawLine( x1, y1, x2, y2, p3);
        if (menuActive==1) canvas.drawRect( x1, y1, x2,y2, p3);
        if (menuActive==2){
            if (!isFirst) {
                canvas.drawCircle( x1, y1, 300, p3);
            }else{
                canvas.drawCircle( x2, y2, 300, p3);
            }
        }
    }


    public void myMenu (Canvas canvas) {
        for(int n = 0; n < 4 ; n++) {
            p1.setStyle(Paint.Style.FILL);
            p1.setColor(Color.YELLOW);
            canvas.drawRect( n*sizeX, 0, 250+sizeX*n, sizeY, p1);
            p1.setColor(Color.BLACK);

            if (n==3) p1.setColor(Color.parseColor("#FF69B4"));
            p1.setAntiAlias(true);
            p1.setTextSize(33);
            p1.setTextAlign(Paint.Align.LEFT);

            canvas.drawText(title[n], n*sizeX+50,(sizeY-30),  p1);
            p1.setTextAlign(Paint.Align.CENTER);
            p1.setTextSize(50);

            canvas.drawRect( n*sizeX, 0, 250+sizeX*n, sizeY, p2);
        }
    }
}
