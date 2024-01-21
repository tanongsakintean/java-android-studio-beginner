package com.example.assign04_6406021622095;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculateVat extends AppCompatActivity {
    Button btnCaleVat,btnVatBack;
    EditText inputVatPrice,resultVatProduct,resultVat,resultTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_vat);

        inputVatPrice = (EditText)  findViewById(R.id.inputVatPrice);
        resultTotal = (EditText)  findViewById(R.id.resultTotal);
        resultTotal.setEnabled(false);
        resultVat = (EditText)  findViewById(R.id.resultVat);
        resultVat.setEnabled(false);
        resultVatProduct = (EditText)  findViewById(R.id.resultVatProduct);
        resultVatProduct.setEnabled(false);


        btnCaleVat = (Button) findViewById(R.id.btnCaleVat);
        btnCaleVat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("###,###.00");
                if (inputVatPrice.getText().toString().isEmpty()) Toast.makeText(CalculateVat.this, "โปรดกรอกราคาสินค้า!", Toast.LENGTH_SHORT).show();
                double price = Double.parseDouble(inputVatPrice.getText().toString());
                double vat = price * 0.07;

                resultVatProduct.setText(df.format(price));
                resultVat.setText(df.format(vat));
                resultTotal.setText(df.format(price + vat));
                inputVatPrice.setText("");
            }
        });


        btnVatBack = (Button) findViewById(R.id.btnVatBack);
        btnVatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}