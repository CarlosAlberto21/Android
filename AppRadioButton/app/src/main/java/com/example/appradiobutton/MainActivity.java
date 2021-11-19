package com.example.appradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private RadioButton rb_s, rb_r;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazo las caja de texto a las variables
        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);
        tv = (TextView)findViewById(R.id.txt_resultado);
        rb_s = (RadioButton)findViewById(R.id.br_suma);
        rb_r = (RadioButton)findViewById(R.id.br_resta);
    }

    public void Calcular(View v){
        //Almaceno los datos obtenidos a otras variables
        String valor1_srtring = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_srtring);
        int valor2_int = Integer.parseInt(valor2_string);

        if(rb_s.isChecked() == true){
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv.setText(resultado);
        }else if(rb_r.isChecked() == true){
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv.setText(resultado);
        }
    }
}