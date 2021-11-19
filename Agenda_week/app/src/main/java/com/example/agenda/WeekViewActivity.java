package com.example.agenda;

import static com.example.agenda.CalendarUtils.diasDeLaSemanaArray;
import static com.example.agenda.CalendarUtils.diasDelmesArray;
import static com.example.agenda.CalendarUtils.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener  {

    private TextView mesDelAno_text;
    private RecyclerView calendarRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setWeekView();
    }

    private void initWidgets(){
        calendarRecyclerView = findViewById(R.id.calendar);
        mesDelAno_text = findViewById(R.id.id_fecha);
    }

    private void setWeekView(){
        mesDelAno_text.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = diasDeLaSemanaArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }



    public void ActionReverseWeek(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void ActionNextWeek(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onIntemClick(int position, String dayText) {

            String message = "Seleccionar fecha " + dayText  + " " + monthYearFromDate(CalendarUtils.selectedDate);
            Toast.makeText(this , message, Toast.LENGTH_SHORT).show();

    }

    public void newEventAction(View view) {
    }
}