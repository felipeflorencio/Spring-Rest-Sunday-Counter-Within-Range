package com.example.innovation.test.repository;

import com.example.innovation.test.model.SundayCounterResponse;
import com.example.innovation.test.util.SundayCounterUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SundayCounterRepository {

    @Cacheable(value = "sundaysCache", key = "#fromDate.toString() + '-' + #toDate.toString()")
    public List<String> findMonthsStartingWithSunday(LocalDate fromDate, LocalDate toDate) {
        List<String> months = SundayCounterUtil.listOfMonthsStartingOnSunday(fromDate, toDate);
        SundayCounterResponse response = new SundayCounterResponse(months);
        return response.getMonths();
    }
}
