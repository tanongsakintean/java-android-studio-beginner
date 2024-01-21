package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateGrade extends AppCompatActivity {
    EditText inputGradeScore,resultGradeScore,resultGrade;
    Button btnCale,btnGradeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_grade);

        inputGradeScore = (EditText) findViewById(R.id.inputGradeScore) ;
        resultGrade = (EditText) findViewById(R.id.resultGrade) ;
        resultGrade.setEnabled(false);
        resultGradeScore = (EditText) findViewById(R.id.resultGradeScore) ;
        resultGradeScore.setEnabled(false);


        btnCale = (Button) findViewById(R.id.btnCale);
        btnCale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputGradeScore.getText().toString().isEmpty()) {
                    Toast.makeText(CalculateGrade.this, "โปรดกรอกคะแนนก่อน!", Toast.LENGTH_SHORT).show();
                }else {
                    resultGradeScore.setText(inputGradeScore.getText().toString());
                    resultGrade.setText(calculateGrade(Integer.parseInt(inputGradeScore.getText().toString())));
                    inputGradeScore.setText("");
                }
            }
        });

        btnGradeBack = (Button) findViewById(R.id.btnGradeBack);
        btnGradeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public String calculateGrade(int score){
        if (score > 79) {
            return "A";
        } else if (score > 74) {
            return "B+";
        } else if (score > 69) {
            return "B";
        }else if (score > 64) {
            return "C+";
        }else if (score > 59) {
            return "C";
        }else if (score > 54) {
            return "D+";
        }else if (score > 49) {
            return "D";
        }else{
            return "F";
        }
    }
}