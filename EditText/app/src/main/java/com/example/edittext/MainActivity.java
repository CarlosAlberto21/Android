package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_name);
        et2 = (EditText)findViewById(R.id.txt_pass);
    }

    public void registro(View v){
        String nombre = et1.getText().toString();
        String contrasena = et2.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this, "Debes Ingresar un Nombre", Toast.LENGTH_SHORT).show();
        }
        if(contrasena.length() == 0){
            Toast.makeText(this, "Debes Ingresar un Password", Toast.LENGTH_SHORT).show();
        }

        if(nombre.length() != 0 && contrasena.length() != 0){
            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_SHORT).show();
        }
    }
}