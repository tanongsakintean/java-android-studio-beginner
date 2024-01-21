package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculatorGrade extends AppCompatActivity implements View.OnClickListener {
    Button btnBack,btnSubmit;
    TextView resultText;
    EditText inputGrade1,inputGrade2,inputGrade3,inputGrade4,inputGrade5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_grade);
         btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
         btnSubmit = (Button)  findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
         inputGrade1 = (EditText) findViewById(R.id.inputGrade1);
         inputGrade2 = (EditText) findViewById(R.id.inputGrade2);
         inputGrade3 = (EditText) findViewById(R.id.inputGrade3);
         inputGrade4 = (EditText) findViewById(R.id.inputGrade4);
         inputGrade5 = (EditText) findViewById(R.id.inputGrade5);
         resultText = (TextView) findViewById(R.id.resultText);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnBack){
            finish();
        } else if (v.getId() == R.id.btnSubmit) {
           resultText.setText(calculateGrade(inputGrade1.getText().toString(),inputGrade2.getText().toString(),inputGrade3.getText().toString(),inputGrade4.getText().toString(),inputGrade5.getText().toString()));
           inputGrade1.setText("");
           inputGrade2.setText("");
           inputGrade3.setText("");
           inputGrade4.setText("");
           inputGrade5.setText("");
           resultText.setBackgroundColor(Color.GREEN);
        }
    }

    public String calculateGrade(String input1,String input2, String input3, String input4, String input5){
        String[] grades;
        int amountSubject = 0;
        double credit = 0.0, totalPoint = 0.0;
        String message = "";
        StringBuilder Grades= new StringBuilder();

        grades = new String[]{input1, input2, input3, input4, input5};

        for (String grade:grades) {
            if(!grade.isEmpty()){
                credit+=3;
                amountSubject++;
                Grades.append(grade).append(",");
                if(grade.equals("A")) totalPoint+= 4 * 3;
                if(grade.equals("B")) totalPoint+= 3 * 3;
                if(grade.equals("C")) totalPoint+= 2 * 3;
                if(grade.equals("D")) totalPoint+= 3;
                if(grade.equals("F")) totalPoint+= 0;
            }
        }

        message+="Result :";
        message+="\nเกรด: "+Grades;
        message+="\nจำนวนวิชา: "+Integer.toString(amountSubject);
        message+="\nจำนวนหน่วยกิต: "+Double.toString(credit);
        message+="\nจำนวนคะแนนที่ได้: "+Double.toString(totalPoint);
        message+="\nเกรดเฉลี่ยที่ได้: "+Double.toString(totalPoint/credit);
        return message;
    }

}