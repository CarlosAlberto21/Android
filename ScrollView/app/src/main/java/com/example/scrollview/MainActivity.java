 package com.example.scrollview;

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

    public void Seleccion(View v){
        switch (v.getId()){
            case R.id.fresas:
                Toast.makeText(this, "Esta es una fresa", Toast.LENGTH_SHORT).show();
                break;


            case R.id.manzanas:
                Toast.makeText(this, "Esta es una manzanas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.franbuesas:
                Toast.makeText(this, "Esta es una franbuesas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.banana:
                Toast.makeText(this, "Esta es una banana", Toast.LENGTH_SHORT).show();
                break;

            case R.id.pera:
                Toast.makeText(this, "Esta es una pera", Toast.LENGTH_SHORT).show();
                break;

            case R.id.pina:
                Toast.makeText(this, "Esta es una pina", Toast.LENGTH_SHORT).show();
                break;

            case R.id.naranja:
                Toast.makeText(this, "Esta es una naranja", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cerezas:
                Toast.makeText(this, "Esta es una cerezas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.zarzamora:
                Toast.makeText(this, "Esta es una zarzamora", Toast.LENGTH_SHORT).show();
                break;

            case R.id.melon:
                Toast.makeText(this, "Esta es una melon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.uvas:
                Toast.makeText(this, "Esta es una uvas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tsandia:
                Toast.makeText(this, "Esta es una sandia", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mangos:
                Toast.makeText(this, "Esta es un mango", Toast.LENGTH_SHORT).show();
                break;

            case R.id.kiwis:
                Toast.makeText(this, "Esto es un kiwi", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}