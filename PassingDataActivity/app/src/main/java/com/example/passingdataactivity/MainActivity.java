package com.example.passingdataactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PLAY_GAME = 1010;
    private EditText textName, textScore;
    private String playerName = "Somchai";
    private int score = 0;
    public static int myData = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (EditText) findViewById(R.id.fieldName);
        textScore = (EditText) findViewById(R.id.fieldScore);
// display initial values
        textName.setText(playerName);
        textScore.setText(""+score);
// setup button listener
        Button startButton = (Button) findViewById(R.id.playBtn);
        startButton.setOnClickListener( this);
        Toast.makeText(this,"data value = " + myData, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Intent lunchGame = new Intent(this,PlayGameActivity.class);
        //passing information to lunched activity
        score = Integer.parseInt(textScore.getText().toString());
        playerName = textName.getText().toString();
        lunchGame.putExtra("score",score);
        lunchGame.putExtra("playerName",playerName);
        startActivityForResult(lunchGame,PLAY_GAME);

    }

    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if ((requestCode == PLAY_GAME) && (resultCode == MainActivity.RESULT_OK)) {
            score = data.getExtras().getInt("score");
            playerName = data.getExtras().getString("playerName");
// show it has changed
            textName.setText(playerName);
            textScore.setText(""+score);
            Toast.makeText(this,"After call , data value = " + myData,

                    Toast.LENGTH_LONG).show();

        }

    }
}