package com.example.agenda;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>{

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<LocalDate> days, CalendarAdapter.OnItemListener onItemListener) {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    //Nos enlaza este adaptador con el archivo calendario_celdas.xml
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendario_celdas, parent, false);
        ViewGroup.LayoutParams layoutParams= view.getLayoutParams();
        //Mes View
        if (days.size() > 15){
            layoutParams.height = (int) (parent.getHeight() * 0.1666666666);
        }
        //semana View
        else {
            layoutParams.height = (int) (parent.getHeight());
        }

        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {

        final LocalDate date = days.get(position);
        if (date == null) {
            holder.diaDelMes.setText("");
        }else {
            holder.diaDelMes.setText(String.valueOf(date.getDayOfMonth()));
            if (date.equals(CalendarUtils.selectedDate))
                holder.parentView.setBackgroundColor(Color.GRAY);
        }

    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface OnItemListener{
        void onIntemClick(int position, String dayText);
    }
}
