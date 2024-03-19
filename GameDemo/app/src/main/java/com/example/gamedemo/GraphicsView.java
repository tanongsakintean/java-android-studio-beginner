package com.example.gamedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import java.util.Random;
public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p;
    private float X, Y;
    private float width, height;
    private Bitmap image, image1;
    private int score, time;
    private CountDownTimer timer1, timer2;
    private boolean finish = false;
    private boolean shoot= false;
    private Random rnd = new Random();
    private int imageWidth, imageHeight;
    public GraphicsView(Context context) {
        super(context);
        setBackgroundColor(Color.argb(150, 10, 10, 10));
        p = new Paint();
        image = BitmapFactory.decodeResource(getResources(),R.drawable.ufo);
        image1 = BitmapFactory.decodeResource(getResources(),R.drawable.ufo_bm);
        score = 0;
        time = 0;
        width = 0;
        height = 0;
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        setOnTouchListener(this);

        timer1 = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                time ++;
                invalidate();
            }
            public void onFinish() {
                finish = true;
                timer2.cancel();
                invalidate();
            }
        };
        timer2 = new CountDownTimer(30000, 1500) {
            public void onTick(long millisUntilFinished) {
                int maxX = (int)(width - imageWidth);
                int maxY = 100 + (int)(height - imageHeight - 100);
                X = (float) rnd.nextInt( Math.abs(maxX) );
                Y = (float) rnd.nextInt( Math.abs(maxY) );
                invalidate();
            }
            public void onFinish() {
                finish = true;
                invalidate();
            }
        };
        timer1.start();
        timer2.start();
    }
    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        if (finish) {
            finish = false;
            timer1.start();
            timer2.start();
            score = 0;
            time = 0;
            invalidate();
        }
        else {
            float x = event.getX();
            float y = event.getY();
            if (isInside(x, y)) {
                shoot = true;
                score += 1;
                invalidate();
            }
        }
        return true;
    }
    private boolean isInside(float xp, float yp)
    {
        if (xp > X && xp < X+image.getWidth())
            if (yp > Y && yp < Y+image.getHeight())
                return(true);
        return(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        if (finish) {
            p.setColor(Color.GREEN);
            p.setTextSize(60);
            p.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("E N D G A M E.", width/2, height/2-100, p);
            canvas.drawText("Touch for Play Game", width/2, height/2 + 100, p);
        }
        else {
            p.setColor(Color.CYAN);
            p.setTextSize(50);
            p.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Score : " + score, 20, 60, p);
            p.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Time : " + time, width-20, 60, p);
            if (shoot) {
                canvas.drawBitmap(image1, X, Y, null);
                shoot = false;
                X = -500;
                Y = -500;
            }
            else
                canvas.drawBitmap(image, X, Y, null);
        }
    }
}