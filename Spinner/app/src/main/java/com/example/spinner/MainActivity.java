package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_valor1);
        et2 = (EditText)findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.resultado);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};


        ArrayAdapter <String> adapter = new ArrayAdapter<String> ( this, R.layout.spinner_item_carlos, opciones);
        spinner1.setAdapter(adapter);

    }

    public void calcular(View v){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_string);
        int valor2_int = Integer.parseInt(valor2_string);

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            String resultados = String.valueOf(suma);
            tv1.setText(resultados);
        } else if(seleccion.equals("Restar")){
            int restar = valor1_int - valor2_int;
            String resultados = String.valueOf(restar);
            tv1.setText(resultados);
        }else if(seleccion.equals("Multiplicar")){
            int multi = valor1_int * valor2_int;
            String resultados = String.valueOf(multi);
            tv1.setText(resultados);
        }else if(seleccion.equals("Dividir")){

            if(valor2_int != 0){
                int div = valor1_int / valor2_int;
                String resultados = String.valueOf(div);
                tv1.setText(resultados);
            }else{
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }
        }


    }
}