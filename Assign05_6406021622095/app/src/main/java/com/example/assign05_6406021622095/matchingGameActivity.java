package com.example.assign05_6406021622095;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.media.MediaPlayer;
import java.text.DecimalFormat;
import java.util.*;

public class matchingGameActivity extends AppCompatActivity  {

    int[] imgs = new int[33]; // Create an array of size 33
    double points = 0;

    TextView showTimer,scorePoint;
    ImageStock[] imgStock = new ImageStock[20];
    CountDownTimer timerPair;
    CountDownTimer timer;
     Button btnStart ;
     DecimalFormat format = new DecimalFormat("#.#");
    MediaPlayer mPlayer;
    private int LOOP_INTERVAL = 200000; // Set your desired loop interval in milliseconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);


        showTimer = (TextView) findViewById(R.id.showTimer);
        scorePoint = (TextView) findViewById(R.id.scorePoint);


        timerPair = new CountDownTimer(60000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                imageStockFilter(imgStock);
            }

            @Override
            public void onFinish() {
            }
        };

        timer= new CountDownTimer(60000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                showTimer.setText("Timer : "+Long.toString(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                btnStart.setEnabled(true);
                for (ImageStock stock:imgStock) stock.getImageButton().setEnabled(false);
                endGame();
                stopSound();
            }
        };





        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            startGame();
            btnStart.setEnabled(false);
        });


    }


    private void playSound(int soundResourceId) {
        if (mPlayer != null) {
            // Release resources before initializing a new MediaPlayer
            mPlayer.release();
        }

        // Create a new MediaPlayer with the specified sound resource
        mPlayer = MediaPlayer.create(this, soundResourceId);

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
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources when the activity is destroyed
        stopSound();
    }



    public void imageStockFilter(ImageStock[] stocks){
        int index = 0;
        ImageStock[] stockSelects = new ImageStock[2];
        for (ImageStock stock:stocks) {
            if (stock.getStatus() && !stock.getPair()) {
                stockSelects[index] = stock;
                index++;
            }
        }

        if (index == 2) {
            try {
                Thread.sleep(200);
                for (ImageStock stock: stockSelects) {
                    if (stockSelects[0].getImageId() == stockSelects[1].getImageId()) {
                        stock.getImageButton().setEnabled(false);
                        stock.setPair(true);
                        points+=0.5;
                        scorePoint.setText("Score : "+format.format(points));
                    }else{
                        stock.getImageButton().setImageResource(R.drawable.question);
                        stock.setPair(false);
                    }
                    stock.setStatus(false);
                }
                index=0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }


    public void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(matchingGameActivity.this);
        builder.setCancelable(true);
        if (points == 10) {
            playSound(R.raw.winner);
            builder.setIcon(R.drawable.winner);
            builder.setTitle("Your are winner");
        }else{
            playSound(R.raw.lose);
            builder.setIcon(R.drawable.dead);
            builder.setTitle("Your are lose");
        }
        builder.setMessage("Are you sure you want to play again ?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            playGame();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());

        builder.create();
        builder.show();
    }

    public void playGame(){
        playSound(R.raw.background);
        points=0;
        int[] ids = randomID();
        for (int i = 0; i < 20; i++) {
            // Constructing the resource ID dynamically
            String buttonId = "imageButton" + (i + 1);
            int resourceBtnId = getResources().getIdentifier(buttonId, "id", getPackageName());

            String drawableName = "img" + ids[i];
            int resourceImgId = getResources().getIdentifier(drawableName, "drawable", getPackageName());

            imgStock[i] = new ImageStock(ids[i],findViewById(resourceBtnId),resourceImgId);
        }


        timerPair.start();
        timer.start();
        for (ImageStock stock: imgStock) stock.getImageButton().setEnabled(true);
    }

    public void startGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(matchingGameActivity.this);
        builder.setCancelable(true);
        builder.setIcon(R.drawable.question);
        builder.setTitle("Start Game?");
        builder.setMessage("Are you sure you want to Start Game ?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            playGame();
            playSound(R.raw.background);
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());

        builder.create();
        builder.show();
    }

    public int[] randomID(){
        int[] randomData = new int[20];

        for (int i = 0; i < 20; i += 2) {
            Random rand = new Random();
            int resultRand;

            // Ensure that consecutive elements are not the same
            do {
                resultRand = rand.nextInt(33);
            } while (resultRand == randomData[i]);

            randomData[i] = resultRand;
            randomData[i + 1] = resultRand;
        }


        shuffleArray(randomData,19);
        return randomData;
    }

    public  void  shuffleArray(int[] array, int end) {
        if (end > 0) {
            shuffleArray(array, end - 1);  // Recursive call for the remaining elements

            // Swap the current element with a randomly chosen element
            Random random = new Random();
            int randomIndex = random.nextInt(end + 1);

            int temp = array[end];
            array[end] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        Intent calculatorActivity = new Intent(matchingGameActivity.this,calculatorActivity.class);
        Intent matchingGameActivity = new Intent(matchingGameActivity.this,matchingGameActivity.class);

        finish();
        if(item.getItemId() == R.id.exit) finishAffinity();
        if(item.getItemId() == R.id.calculator) startActivity(calculatorActivity);
        if(item.getItemId() == R.id.matchingGame) startActivity(matchingGameActivity);
        return true;
    }

}

class ImageStock {
  private   boolean status = false;
  private   int imageId;
  private int image;


  private   ImageButton imageButton ;

  private   boolean isPair = false;

    public ImageStock(int imageId,ImageButton imgBtn,int image) {
        this.imageId = imageId;
        this.image = image;
        this.status = false;
        this.setImageButton(imgBtn);
        this.imageButton.setEnabled(false);

    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    public int getImageId(){
        return this.imageId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
        this.imageButton.setImageResource(R.drawable.question);
        this.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatus(!getStatus());
                imageButton.setImageResource(image);
            }
        });
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setPair(boolean pair) {
        isPair = pair;
    }

    public boolean getPair() {
        return isPair;
    }


}