package com.example.personajesrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Esta clase se encarga de suministrarle los elementos al archivo item_list_personajes.xml
public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes>{

    ArrayList<PersonajeVo> listaPersonajes;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override

    //Metodo para enviar los elementos que se van a mostrar en el xml
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list_personajes, null, false);
        return new ViewHolderPersonajes(view);
    }

    //Metodo que recibe los datos y los ordena para luego enviarlo con el metodo onCreateViewHolder al xml
    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonajes holder, int position) {
        holder.nombreT.setText(listaPersonajes.get(position).getNombre());
        holder.infoT.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    //Metodo que cuenta el numero de elementos que se van enviar
    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    //En esta clase la enlaso al xml para enviarle los elementos que inflamos con el metodo ViewHolderPersonajes onCreateViewHolder y mostrarlo en el xml
    public class ViewHolderPersonajes extends RecyclerView.ViewHolder{

        TextView nombreT, infoT;
        ImageView foto;

        public ViewHolderPersonajes(@NonNull View itemView) {
            super(itemView);
            nombreT = (TextView) itemView.findViewById(R.id.idNombre);
            infoT = (TextView) itemView.findViewById(R.id.idDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.idImg);
        }
    }
}
