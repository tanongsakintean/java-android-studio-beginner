package com.example.lesson10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   private   Button btnAdd, btnClear, btnFindMin;
  private   TextView labelShow;
  private   EditText numText;
  private Integer[] num;
    private Integer min = 0;
    private Integer count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = new Integer[5];

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnClear.setEnabled(false);
        btnFindMin = (Button) findViewById(R.id.btnMin);
        btnFindMin.setEnabled(false);
        btnFindMin.setOnClickListener(this);

        numText = (EditText) findViewById(R.id.numText);
        labelShow = (TextView) findViewById(R.id.labelShow);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd && count != 4 && !numText.getText().toString().matches("")) {
            num[++count] = (Integer.parseInt(numText.getText().toString()));
            if (count == 0) {
                min = num[count];
            } else{
                min = findMin(min,num[count]);
            }

            btnClear.setEnabled(true);
            btnFindMin.setEnabled(true);
            numText.setText("");
            labelShow.append("\n->"+num[count]);
        } else if (v.getId() == R.id.btnClear) {
                count = -1;
                min = 0;
                labelShow.setText("Value Number Add :");
                btnClear.setEnabled(false);
                btnFindMin.setEnabled(false);
                btnAdd.setEnabled(true);
        } else if (v.getId() == R.id.btnMin) {
            Toast.makeText(this, "Minimum number is = "+min, Toast.LENGTH_LONG).show();
        }else if(count == 4){
            Toast.makeText(this, "Add 5 Numbers!", Toast.LENGTH_LONG).show();
        }


    }
    
    public  Integer findMin(Integer num1, Integer num2){
        return num1 > num2 ? num2 : num1;
    }
}









