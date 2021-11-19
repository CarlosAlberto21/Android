package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText)findViewById(R.id.txt_num1);
        edt2 = (EditText)findViewById(R.id.txt_num2);
        tv = (TextView)findViewById(R.id.txt_resultado);

    }

    public void Sumar(View v){
        String valor1 = edt1.getText().toString();
        String valor2 = edt2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        int suma = num1 + num2;

        String result = String.valueOf(suma);
        tv.setText(result);

    }
}