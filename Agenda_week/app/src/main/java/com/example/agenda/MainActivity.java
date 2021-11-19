package com.example.agenda;

import static com.example.agenda.CalendarUtils.diasDelmesArray;
import static com.example.agenda.CalendarUtils.monthYearFromDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void initWidgets(){
        calendarRecyclerView = findViewById(R.id.calendar);
        mesDelAno_text = findViewById(R.id.id_fecha);
    }

    private void setMonthView(){
        mesDelAno_text.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<String> diasDelMes = diasDelmesArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(diasDelMes, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    public void ActionReverse(View v){
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void ActionNext(View v){
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
         setMonthView();
    }

    @Override
    public void onIntemClick(int position, String dayText) {
        if (!dayText.equals("")){
            String message = "Seleccionar fecha " + dayText  + " " + monthYearFromDate(CalendarUtils.selectedDate);
            Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
        }
    }

    //Este mentodo enlaza la clase WeekViewActivity a esta clase
    public void weeklyAction(View view) {
        startActivity(new Intent(this, WeekViewActivity.class));
    }


}