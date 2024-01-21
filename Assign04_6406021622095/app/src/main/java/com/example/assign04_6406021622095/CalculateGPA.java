package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class CalculateGPA extends AppCompatActivity {
    Button btnGPACale,btnGPABack;
    EditText inputGrade1,inputGrade2,inputGrade3,inputGrade4,resultGPAPoint,resultGPACredit,resultGPATotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_gpa);

        inputGrade1 = (EditText)  findViewById(R.id.inputGrade1);
        inputGrade2 = (EditText)  findViewById(R.id.inputGrade2);
        inputGrade3 = (EditText)  findViewById(R.id.inputGrade3);
        inputGrade4 = (EditText)  findViewById(R.id.inputGrade4);
        resultGPACredit = (EditText)  findViewById(R.id.resultGPACredit);
       resultGPAPoint = (EditText)  findViewById(R.id.resultGPAPoint);
        resultGPATotal = (EditText)  findViewById(R.id.resultGPATotal);

        btnGPABack = (Button) findViewById(R.id.btnGPABack);
        btnGPABack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGPACale = (Button) findViewById(R.id.btnGPACale);
        btnGPACale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("###,###.00");
                String[] grades = {inputGrade1.getText().toString(),inputGrade2.getText().toString(),inputGrade3.getText().toString(),inputGrade4.getText().toString()};
                double point = 0,credits = 0,gpa = 0.0;

                for (String grade:grades) {
                    credits+=3.0;
                    if(grade.equals("A")) point+= 4*3;
                    if(grade.equals("B+")) point+= 3.5*3;
                    if(grade.equals("B")) point+= 3*3;
                    if(grade.equals("C+")) point+= 2.5*3;
                    if(grade.equals("C")) point+= 2*3;
                    if(grade.equals("D+")) point+= 1.5*3;
                    if(grade.equals("D")) point+= 3;
                }

                gpa =  point / credits;

                resultGPACredit.setText(df.format(credits));
                resultGPAPoint.setText(df.format(point));
                resultGPATotal.setText(df.format(gpa));

                inputGrade1.setText("");
                inputGrade2.setText("");
                inputGrade3.setText("");
                inputGrade4.setText("");
            }
        });

    }
}