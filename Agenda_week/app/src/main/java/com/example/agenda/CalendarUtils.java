package com.example.agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarUtils {

    //Atributo para fijar fecha
    public static LocalDate selectedDate;

    public static String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyyy");
        return  date.format(formatter);
    }

    public static ArrayList<LocalDate> diasDelmesArray(LocalDate date){
        ArrayList<LocalDate> diasDelMesArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int diasDelMes = yearMonth.lengthOfMonth();
        LocalDate primerDiaDelMes = CalendarUtils.selectedDate.withDayOfMonth(1);
        int dayOfWeek = primerDiaDelMes.getDayOfWeek().getValue();

        for (int i = 1; i <=  42; i++)
        {
            if (i <=  dayOfWeek || i > diasDelMes + dayOfWeek)
            {
                diasDelMesArray.add(null);
            }else
            {
                diasDelMesArray.add(LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), i - dayOfWeek));
            }
        }
        return diasDelMesArray;
    }

    public static ArrayList<LocalDate> diasDeLaSemanaArray(LocalDate selectedDate) {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current = sundayForDate(selectedDate);
        LocalDate endDate = current.plusWeeks(1);
        while (current.isBefore(endDate)){
            days.add(current);
            current = current.plusDays(1);
        }
        return days;
    }

    private static LocalDate sundayForDate(LocalDate current) {
        LocalDate oneWeekAgo = current.minusWeeks(1);

        while (current.isAfter(oneWeekAgo)){
               if (current.getDayOfWeek() == DayOfWeek.SUNDAY){
                    return current;

                    current = current.minusDays(1);
               }

               return null;
        }
    }
}
