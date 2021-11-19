package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_email);

        SharedPreferences sp = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(sp.getString("mail", ""));
    }

    public void guardar(View v){
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor obj_editor = preferencias.edit();
            obj_editor.putString("mail", et1.getText().toString());
            obj_editor .commit();
            finish();
    }
}