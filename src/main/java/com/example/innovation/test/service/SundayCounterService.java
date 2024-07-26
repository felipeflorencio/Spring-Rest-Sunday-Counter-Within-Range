package com.example.innovation.test.service;

import com.example.innovation.test.exception.InvalidDateRangeException;
import com.example.innovation.test.repository.SundayCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SundayCounterService {

    @Autowired
    private SundayCounterRepository sundayCounterRepository;

    public List<String> getMonthsStartingWithSunday(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new InvalidDateRangeException("The provided date is invalid", "Either 'from' or 'to' date is null.");
        }

        if (fromDate.isAfter(toDate)) {
            throw new InvalidDateRangeException("The provided date range is invalid", "'From' date is after 'to' date.");
        }

        return sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate);
    }
}
