package com.example.innovation.test;

import com.example.innovation.test.repository.SundayCounterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SundayCounterRepositoryTest {

    @Autowired
    private SundayCounterRepository sundayCounterRepository;

    @Test
    public void testFindMonthsStartingWithSunday() {
        LocalDate fromDate = LocalDate.of(2023, 1, 1);
        LocalDate toDate = LocalDate.of(2024, 12, 31);

        List<String> expectedMonths = Arrays.asList("January 2023", "October 2023", "September 2024", "December 2024");

        List<String> result = sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate);

        // Verify the repository method returns the expected results
        assertEquals(expectedMonths, result);
    }
}
