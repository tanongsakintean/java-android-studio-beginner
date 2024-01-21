package com.example.passingdataactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText playerName, playerScore;
    int score;
    String author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        playerName = (EditText) findViewById(R.id.fieldPlayerName);
        playerScore = (EditText) findViewById(R.id.fieldPlayerScore);
        readInfoFromActivity();
// setup button listener
        Button endButton = (Button) findViewById(R.id.back_button);
        endButton.setOnClickListener( this);
        Toast.makeText(this,"data from main : " + MainActivity.myData,

                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        author = playerName.getText().toString();
        score = Integer.parseInt( playerScore.getText().toString() );
        intent.putExtra("score",score);
        intent.putExtra("playerName", author);
        setResult(PlayGameActivity.RESULT_OK, intent);
        MainActivity.myData = score;
        finish();
    }

    public void readInfoFromActivity() {
// reading information passed to activity
        Intent intent = getIntent();
// return -1 if not initialized by calling activity
        score = intent.getIntExtra("score", -1);
// return [] if not initialized by calling activity
        author = intent.getStringExtra("playerName");
// display initial values
        playerName.setText(author);
        playerScore.setText( "" + score);
    }
}