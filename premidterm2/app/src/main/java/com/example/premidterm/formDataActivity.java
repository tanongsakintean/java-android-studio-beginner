package com.example.premidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class formDataActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public  String[] inputAges;
   public TextInputEditText fname,lname,email;
   public RadioButton radioBoy,radioGirl;
  public   Spinner age;
  public   CheckBox checkBoxGrape,checkBoxOrange;
   public Button btnSubmit;
   public  String myAge = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data);
        inputAges = new String[30];
        for (int i = 1; i <= 30; i++) {
            inputAges[i-1] = Integer.toString(i);
        }

       age = (Spinner) findViewById(R.id.age);
        ArrayAdapter<String> inputs = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,inputAges);
        age.setAdapter(inputs);
        age.setOnItemSelectedListener(this);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        checkBoxOrange = (CheckBox) findViewById(R.id.checkBoxOrange);
        checkBoxGrape = (CheckBox) findViewById(R.id.checkBoxGrape);

        radioBoy = (RadioButton) findViewById(R.id.radioBoy);
        radioGirl = (RadioButton) findViewById(R.id.radioGirl);

        fname = (TextInputEditText) findViewById(R.id.fname);
        lname = (TextInputEditText) findViewById(R.id.lname);
        email = (TextInputEditText) findViewById(R.id.email);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit && validateForm()) {
            String message = "Result:\n";
            message+="first name : "+fname.getText().toString()+"\n";
            message+="last name : "+lname.getText().toString()+"\n";
            message+="email : "+email.getText().toString()+"\n";
             if(radioBoy.isChecked()){ message+="gender : "+ "ชาย"+"\n";}else{ message+="age : "+"หญิง" +"\n";}
             message+="age : "+myAge+" ปี\n";
            if(checkBoxGrape.isChecked() || checkBoxOrange.isChecked()) message+="ชอบกินผลไม้ : ";
            if (checkBoxOrange.isChecked()) message+="ส้ม ";
            if (checkBoxGrape.isChecked()) message+="องุ่น ";

            Toast.makeText(formDataActivity.this,message,Toast.LENGTH_LONG).show();




        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myAge = inputAges[position];
    }

    public boolean validateForm(){
      int  status = 0;
        if(TextUtils.isEmpty(fname.getText().toString().trim())){fname.setError("Please Enter first name!");status+=1;}
        if(TextUtils.isEmpty(lname.getText().toString().trim())){lname.setError("Please Enter last name!");status+=1;}
        if(TextUtils.isEmpty(email.getText().toString().trim())){email.setError("Please Enter email!");status+=1;}
        if (!radioBoy.isChecked() && !radioGirl.isChecked())status+=1;



        return status == 0;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}