package com.example.agenda;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>{

    private final ArrayList<String> diasDelMes;
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<String> diasDelMes, CalendarAdapter.OnItemListener onItemListener) {
        this.diasDelMes = diasDelMes;
        this.onItemListener = onItemListener;
    }

    //Nos enlaza este adaptador con el archivo calendario_celdas.xml
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendario_celdas, parent, false);
        ViewGroup.LayoutParams layoutParams= view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.1666666666);
        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.diaDelMes.setText(diasDelMes.get(position));
    }

    @Override
    public int getItemCount() {
        return diasDelMes.size();
    }

    public interface OnItemListener{
        void onIntemClick(int position, String dayText);
    }
}
