package com.example.innovation.test;

import com.example.innovation.test.util.SundayCounterUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SundayCounterUtilTest {

    @Test
    void testListOfMonthsStartingOnSunday() {
        LocalDate fromDate = LocalDate.of(2022, 1, 1);
        LocalDate toDate = LocalDate.of(2023, 12, 31);
        List<String> result = SundayCounterUtil.listOfMonthsStartingOnSunday(fromDate, toDate);
        assertTrue(result.contains("May 2022"));
        assertTrue(result.contains("January 2023"));
    }

    @Test
    public void testGetDayOfWeek() {
        assertEquals(7, SundayCounterUtil.getDayOfWeek(1, 8, 2021)); // 1st August 2021 is a Sunday
        assertEquals(1, SundayCounterUtil.getDayOfWeek(2, 8, 2021)); // 2nd August 2021 is a Monday
    }

    @Test
    public void testCountSundaysOnFirstDayInRange() {
        int startYear = 1901;
        int startMonth = 1;
        int startDay = 1;
        int endYear = 2000;
        int endMonth = 12;
        int endDay = 31;

        assertEquals(171, SundayCounterUtil.countSundaysOnFirstDayInRange(startYear, startMonth, startDay, endYear, endMonth, endDay));
    }
}
