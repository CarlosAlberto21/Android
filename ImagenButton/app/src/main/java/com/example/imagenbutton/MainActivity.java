package com.example.imagenbutton;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonUno(View v){
        Toast.makeText(this, "Primer Boton", Toast.LENGTH_SHORT).show();
    }

    public void botonDos(View v){
        Toast.makeText(this, "Segundo Boton", Toast.LENGTH_SHORT).show();
    }
}