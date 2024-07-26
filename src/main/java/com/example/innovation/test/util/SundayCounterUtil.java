package com.example.innovation.test.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SundayCounterUtil {

    public static List<String> listOfMonthsStartingOnSunday(LocalDate fromDate, LocalDate toDate) {
        List<String> months = new ArrayList<>();
        LocalDate current = fromDate.withDayOfMonth(1);

        while (!current.isAfter(toDate)) {
            if (current.getDayOfWeek().getValue() == 7) { // 7 represents Sunday
                months.add(current.getMonth() + " " + current.getYear());
            }
            current = current.plusMonths(1);
        }

        return months
                .stream()
                .map(SundayCounterUtil::capitalize)
                .toList();
    }

    public static int getDayOfWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue(); // 1=Monday, ..., 7=Sunday
    }

    public static int countSundaysOnFirstDayInRange(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        int totalSundays = 0;
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        LocalDate current = startDate.withDayOfMonth(1);
        while (!current.isAfter(endDate)) {
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalSundays++;
            }
            current = current.plusMonths(1);
        }


        return totalSundays;
    }

    private static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
