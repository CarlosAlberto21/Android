package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private TextView mesDelAno_text;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets(){
        calendarRecyclerView = findViewById(R.id.calendar);
        mesDelAno_text = findViewById(R.id.id_fecha);
    }

    private void setMonthView(){
        mesDelAno_text.setText(monthYearFromDate(selectedDate));
        ArrayList<String> diasDelMes = diasDelmesArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(diasDelMes, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private ArrayList<String> diasDelmesArray(LocalDate date){
        ArrayList<String> diasDelMesArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int diasDelMes = yearMonth.lengthOfMonth();
        LocalDate primerDiaDelMes = selectedDate.withDayOfMonth(1);
        int diaDeLaSemana = primerDiaDelMes.getDayOfWeek().getValue();

        for (int i = 1; i <=  42; i++)
        {
            if (i <=  diaDeLaSemana || i > diasDelMes + diaDeLaSemana)
            {
                diasDelMesArray.add("");
            }else
            {
                diasDelMesArray.add(String.valueOf(i - diaDeLaSemana));
            }
        }
        return diasDelMesArray;
    }

    private String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyyy");
        return  date.format(formatter);
    }

    public void ActionReverse(View v){
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    public void ActionNext(View v){
         selectedDate = selectedDate.plusMonths(1);
         setMonthView();
    }

    @Override
    public void onIntemClick(int position, String dayText) {
        if (!dayText.equals("")){
            String message = "Seleccionar fecha " + dayText  + " " + monthYearFromDate(selectedDate);
            Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
        }
    }
}