package com.example.parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = (TextView)findViewById(R.id.txt_dato);
        String mensaje = getIntent().getStringExtra("dato");
        tv.setText("Hola " + mensaje);
    }

    public void devolver(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}