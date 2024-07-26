package com.example.innovation.test;

import com.example.innovation.test.repository.SundayCounterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SundayCounterRepositoryCachingTest {

    @Autowired
    private SundayCounterRepository sundayCounterRepository;

    @Autowired
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        // Clear the cache before each test
        cacheManager.getCache("sundaysCache").clear();
    }

    @Test
    public void testCaching() {
        LocalDate fromDate = LocalDate.of(1998, 1, 1);
        LocalDate toDate = LocalDate.of(2024, 12, 31);

        // First call: should calculate and cache the result
        List<String> result1 = sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate);
        assertEquals(result1, sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate));

        // Second call: should return the cached result
        List<String> result2 = sundayCounterRepository.findMonthsStartingWithSunday(fromDate, toDate);
        assertEquals(result1, result2);
    }
}
