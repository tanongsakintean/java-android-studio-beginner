package com.example.fileinternaldemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    String myPath;
    final int READ_BLOCK_SIZE = 100;

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
        myPath = "/data/data/"+getPackageName()+"/files/";
    }
    @Override
    public void onClick(View v) {
        String id , name, score;
        if (v.getId() == R.id.btnSave) {
            name = nameText.getText().toString();
            score = scoreText.getText().toString();
            if (checkData(name, score)) {
                saveFile( name, score);
            } else {
                Toast.makeText(this, "ข้อมูลไม่ครบ", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.btnLoad) {
            File file = new File(myPath+FILENAME);
            if (file.exists())
                loadFile();
            else {
                showData.setText( file.getPath() );
                Toast.makeText(this, "ไม่มีไฟล์ "+FILENAME,
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
    public boolean checkData(String name, String score) {
        if ( !name.isEmpty() && !score.isEmpty())
            return(true);
        return(false);
    }
    public void saveFile(String name,String score) {
        try {
// หากต้องการเพิ่มข้อมูลต่อในไฟล์ด้วยกันให้เปลี่ยนเป็น MODE_APPEND
            FileOutputStream fout = openFileOutput(FILENAME, MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fout);
            writer.write(name+ " " +score+"\n");
            writer.flush();
            writer.close();
            nameText.setText("");
            scoreText.setText("");
            Toast.makeText(this, "บันทึกเรียบร้อย", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {Toast.makeText(this, "เกิดข้อผิดพลาด ไม่สามารถบันทึกได้",
                Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
    }
    public void loadFile() {
        try {
            FileInputStream fin = openFileInput(FILENAME);
            InputStreamReader reader = new InputStreamReader(fin);
            char [] buffer = new char[READ_BLOCK_SIZE];
            int countRead = 0;
            String data = "";
            while ( (countRead = reader.read(buffer)) > 0 ) {
                data += String.copyValueOf(buffer);
                buffer = new char[READ_BLOCK_SIZE];
            }
            reader.close();
            fin.close();
            showData.setText( data );
            Toast.makeText(this, "โหลดข้อมูลเสร็จเรียบร้อย", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "เกิดข้อผิดพลาด ไม่สามารถโหลดได้",
                    Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
    }
}