package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_matematica);
        et2 = (EditText)findViewById(R.id.txt_quimica);
        et3 = (EditText)findViewById(R.id.txt_fisica);
        tv = (TextView)findViewById(R.id.txt_resultado);
    }

    public void Promedio(View view){

        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        String valor3 = et3.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int num3 = Integer.parseInt(valor3);

        int totalPromedio = (num1 + num2 + num3) / 3;

        String result = String.valueOf(totalPromedio);
        tv.setText(result);

    }
}