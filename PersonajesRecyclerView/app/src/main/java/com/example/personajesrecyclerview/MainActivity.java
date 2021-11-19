package com.example.personajesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);

        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();

        AdaptadorPersonajes adaptador = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adaptador);
    }

    //Este metodo nos ayuda a llenar el arreglo con los
    public void llenarPersonajes(){
        listaPersonajes.add(new PersonajeVo("Goku", "Es un Sayayin criado en la Tierra", R.drawable.goku));
        listaPersonajes.add(new PersonajeVo("Vegueta", "Es el Principe de los Sayayin", R.drawable.vegueta));
    }
}