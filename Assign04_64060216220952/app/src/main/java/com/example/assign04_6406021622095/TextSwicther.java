package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwicther extends AppCompatActivity {

    private TextSwitcher switcher;
    private Button btnPrevious, btnNext;
    private static final String []TEXT = {
            "When in Rome, do as the Romans",
            "The squeaky wheel gets the grease",
            "Two wrongs don't make a right",
            "Hope for the best, but prepare for the worst",
            "A picture is worth a thousand words"};

    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_swicther);

        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        switcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize( 20);
                return textView;
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPosition > 0) {
                    mPosition = mPosition-1;
                    switcher.setText(TEXT[mPosition]);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPosition < TEXT.length-1) {
                    mPosition = mPosition+1;
                    switcher.setText(TEXT[mPosition]);

                }
            }
        });
    }

}