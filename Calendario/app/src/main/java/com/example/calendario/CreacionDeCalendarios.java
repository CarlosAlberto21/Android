package com.example.calendario;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreacionDeCalendarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_de_calendarios);

    }

    public void AddCalendario(View v){
        Intent add = new Intent(this, Calendario.class);
        startActivity(add);
    }
}