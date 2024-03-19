package com.example.assign06_6406021622095_ufo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Random;
public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p; // สร้างแปรงทาสี
    private float eventX,eventY; /// สร้างเพื่อเก็บ x y จากการคลิก
    private float width, height; // สร้างเพื่อเก็บ ความกวาง และ ความสูง
    private Bitmap image, image1; // สร้างเพื่อ เก็บ รูป ufo และ รูป ufo ระเบิด
    private int score, time; // สร้างเพื่อ เก็บ คะแนนสะสม และ เวลาถอยหลัง
    private CountDownTimer timer1, timer2; // ตัวนับเวลาที่เรากำหนด
    private boolean finish = false; // สร้งเพื่อเช็คว่าเมื่อจบเกมส์
    private int imageWidth, imageHeight; // สร้างเพื่อ เก็บ ความสูงและความกวางของรูปภาพ
    MediaPlayer mPlayer; // สร้างเพื่อเรียกใช้งานเสียง
    private int LOOP_INTERVAL = 800; // สร้าง เพื่อเล่นเสียงรอบละ 1 มิลลืินาที

    private ArrayList<Ufo> ufos = new ArrayList<Ufo>(); // สร้ง list ของ class ของ ufo

    public GraphicsView(Context context) {
        super(context);
        setBackgroundColor(Color.BLACK);
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
        timer1 = new CountDownTimer(30000, 500) {
            public void onTick(long millisUntilFinished) {
                time = (int) (millisUntilFinished / 1000);
                ufos.add(new Ufo(image,image1,imageWidth));
                invalidate();
            }
            public void onFinish() {
                ufos.clear();
                finish = true;
                timer2.cancel();
                invalidate();
            }
        };

        timer2 = new CountDownTimer(30000, 20) {
            public void onTick(long millisUntilFinished) {
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
            eventX = event.getX();
            eventY = event.getY();
        }
        return true;
    }


    private void playSound(int soundResourceId) {
        if (mPlayer != null) {
            // Release resources before initializing a new MediaPlayer
            mPlayer.release();
        }

        // Create a new MediaPlayer with the specified sound resource
        mPlayer = MediaPlayer.create(this.getContext(), soundResourceId);

        if (mPlayer != null) {
            // Set looping to true for infinite playback
            mPlayer.setLooping(true);

            // Start playing the sound
            mPlayer.start();
        }

        // Optional: Use a handler to stop playback after a specific interval
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                stopSound();
            }
        }, LOOP_INTERVAL);
    }

    private void stopSound() {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        for (int i = 0; i < ufos.size() ; i++) {
            ufos.get(i).ufoMove(canvas);
            if (ufos.get(i).isShoot(eventX,eventY)) {
                //play sound on shoot
                playSound(R.raw.gun);
                ufos.get(i).ufoMove(canvas);
                ufos.remove(i);
                score+=1;
            }

            if (ufos.get(i).getY() > 2560) {
                ufos.remove(i);
            }

        }
        if (finish) endGame(canvas);
        if (!finish) {
            p.setColor(Color.YELLOW);
            p.setTextSize(50);
            p.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Score : " + score, 20, 60, p);
            p.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Time : " + time, width-20, 60, p);
            }
        }





    public void endGame(Canvas canvas){
        p.setColor(Color.GREEN);
        p.setTextSize(60);
        p.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Time Out!", width/2, height/2-100, p);
        canvas.drawText("Press for play game again or back to exit", width/2, height/2 + 100, p);
    }

}

class Ufo {
    Bitmap ufo , ufoBm;
    private boolean shoot= false;
    float X,Y=0;
    float speed ;
    private Random rnd = new Random();

    private int imageWidth ;


    public Ufo(Bitmap ufo,Bitmap ufoBm, int imageWidth){
        setUfo(ufo);
        setUfoBm(ufoBm);
        setPosition(imageWidth);
    }

    public void ufoMove(Canvas canvas){
        Y+=speed;
        if (shoot) {
            canvas.drawBitmap(ufoBm, X, Y, null);
            shoot = false;
        }else{
            canvas.drawBitmap(ufo, X, Y, null);
        }


    }


    public void setPosition(int imageWidth){
        this.imageWidth=imageWidth;
        X = (float) rnd.nextInt( Math.abs( (int)(1600-imageWidth)) );
        speed = (float) rnd.nextInt( 10)+1;
    }

    public boolean isShoot(float x, float y){
        if (x > X && x < X+ufo.getWidth()) {
            if (y > Y && y < Y + ufo.getHeight()) {
                shoot = true;
                return (true);
            }
        }
        return(false);
    }


    public void setUfoBm(Bitmap ufoBm) {
        this.ufoBm = ufoBm;
    }


    public void setUfo(Bitmap ufo) {
        this.ufo = ufo;
    }



    public float getY() {
        return Y;
    }
}
