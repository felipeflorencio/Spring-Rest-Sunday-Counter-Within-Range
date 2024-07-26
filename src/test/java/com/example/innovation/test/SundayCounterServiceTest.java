package com.example.innovation.test;

import com.example.innovation.test.exception.InvalidDateRangeException;
import com.example.innovation.test.repository.SundayCounterRepository;
import com.example.innovation.test.service.SundayCounterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SundayCounterServiceTest {
    @Mock
    private SundayCounterRepository sundayCounterRepository;

    @InjectMocks
    private SundayCounterService sundayCounterService;

    @Test
    void testGetMonthsStartingWithSundayValidDates() {
        LocalDate fromDate = LocalDate.of(2022, 1, 1);
        LocalDate toDate = LocalDate.of(2023, 12, 31);
        when(sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate))
                .thenReturn(List.of("May 2022", "January 2023"));

        List<String> result = sundayCounterService.getMonthsStartingWithSunday(fromDate, toDate);
        assertEquals(2, result.size());
        assertTrue(result.contains("May 2022"));
        assertTrue(result.contains("January 2023"));
    }

    @Test
    void testGetMonthsStartingWithSundayInvalidDateRange() {
        LocalDate fromDate = LocalDate.of(2023, 1, 1);
        LocalDate toDate = LocalDate.of(2022, 12, 31);

        InvalidDateRangeException exception = assertThrows(
                InvalidDateRangeException.class,
                () -> sundayCounterService.getMonthsStartingWithSunday(fromDate, toDate)
        );

        assertEquals("The provided date range is invalid", exception.getMessage());
    }
}
