package com.example.appspinnerimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private String [] inputs = { "Pakistan", "Iran", "China", "India",
            "Thailand", "U.A.E", "Yemen", "Palestine",
            "America", "Australia", "Turkey", "England",
            "France", "Greece"};
    private String [] names = {"deosai_land", "dudipatsar_lake","rama_lake"};

    private ImageView imgShow;
    private Spinner spinner1,spinner2;
    ImageButton btnSave,btnView;
    private  int pos1 = 0,pos2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String>  country = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,inputs);
        spinner1.setAdapter(country);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> pictures = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,names);
        spinner2.setAdapter(pictures);
        spinner2.setOnItemSelectedListener(this);

        btnSave = (ImageButton) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnView = (ImageButton) findViewById(R.id.btnView);
        btnView.setOnClickListener(this);

        imgShow = (ImageView) findViewById(R.id.imgShow);
    }

    @Override
    public void onClick(View v) {
        String message = "";
        if(v.getId() == R.id.btnSave) {
            message = "Country : " + spinner1.getItemAtPosition(pos1);
            Toast.makeText(this, "You select : " + inputs[pos1],
                    Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.btnView){
            if (pos2 == 0)
                imgShow.setImageResource(R.drawable.deosai_land);
            else if (pos2 == 1)
                imgShow.setImageResource(R.drawable.dudipatsar_lake);
            else if (pos2 == 2)
                imgShow.setImageResource(R.drawable.rama_lake);
            message = "Picture : " + spinner2.getItemAtPosition(pos2);
            Toast.makeText(this, "You select : " + names[pos2],

                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(adapterView.getId() == R.id.spinner1) Toast.makeText(this, inputs[position], Toast.LENGTH_SHORT).show();
        if(adapterView.getId() == R.id.spinner2) Toast.makeText(this, names[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}