package com.example.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView textView;
    GradientDrawable gd;
    int color = Color.LTGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gd = new GradientDrawable();
        gd.setStroke( 3, Color.RED);
        gd.setColor(Color.LTGRAY);
        gd.setCornerRadius( 30);
        textView = (TextView) findViewById(R.id.textView);
        textView.setBackground( gd);
        textView.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textView) {
            showAlertDialog1();
        }
        else {
            showAlertDialog2();
        }
    }

    public void showAlertDialog1() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        builder.setTitle("Message");
        builder.setMessage("ทดสอบการท างานของ Alert ?");
        builder.setPositiveButton("คกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (color == Color.LTGRAY) {
                    gd.setColor(Color.WHITE);
                    color = Color.WHITE;
                }
                else if (color == Color.WHITE) {
                    gd.setColor(Color.LTGRAY);
                    color = Color.LTGRAY;
                }
                textView.setBackground(gd);
            }
        });
        builder.create().show();
    }
    public void showAlertDialog2() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to leave ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }
}