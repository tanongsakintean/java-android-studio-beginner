package com.example.fileexternaldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    EditText nameText, scoreText;
    Button btnSave, btnLoad;
    TextView showData;
    final String FILENAME = "data.txt";
    final String FILEPATH = "/mystorage";
    File myExternalFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        scoreText = findViewById(R.id.scoreText);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
        showData = findViewById(R.id.showData);
        if (!isExternalStroageAvailable() || isExternalStroageReadOnly())
            btnSave.setEnabled(false);
        else {
            // make file
            ContextWrapper contextWrapper =

                    new ContextWrapper(getApplicationContext());

          //  myExternalFile  path file
            myExternalFile =

                    new File(contextWrapper.getExternalFilesDir(FILEPATH), FILENAME);

            showData.setText( myExternalFile.toString() );
        }
    }
    @Override
    public void onClick(View v) {
        String id , name, score;
        if (v.getId() == R.id.btnSave) {
            name = nameText.getText().toString();
            score = scoreText.getText().toString();
            if (checkData(name, score)) {
                writeFile(name, score);
            }
            else {
                Toast.makeText(this, "ข้อมูลไม่ครบ", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.btnLoad) {
            if (!myExternalFile.exists() ) {
                Toast.makeText(this, "ไม่มีไฟล์ "+FILENAME,
                        Toast.LENGTH_SHORT).show();

                return;
            }
            readFile();
        }
    }
    public void writeFile(String name,String score) {
        String data = name + " " + score + "\n";
        try {
            FileOutputStream fileOut = new FileOutputStream(myExternalFile,true);
            fileOut.write(data.getBytes());
            fileOut.close();
            nameText.setText("");
            scoreText.setText("");
            Toast.makeText(this, "บันทึกเรียบร้อย", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        try {
            FileInputStream fileIn = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fileIn);
            InputStreamReader inputRead = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputRead);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while (( line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
            inputRead.close();
            in.close();
            fileIn.close();
            String data = stringBuilder.toString();
            showData.setText( data );
            Toast.makeText(this, "โหลดข้อมูลเสร็จเรียบร้อย", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean checkData( String name, String score) {
        if ( !name.isEmpty() && !score.isEmpty())
            return(true);
        return(false);
    }
    public boolean isExternalStroageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) return true;
        return false;
    }
    public boolean isExternalStroageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}