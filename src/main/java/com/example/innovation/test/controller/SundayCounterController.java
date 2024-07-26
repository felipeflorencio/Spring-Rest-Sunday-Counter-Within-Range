package com.example.innovation.test.controller;

import com.example.innovation.test.exception.InvalidDateRangeException;
import com.example.innovation.test.service.SundayCounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SundayCounterController {

    @Autowired
    private SundayCounterService sundayCounterService;

    /// The chosen patter for input is ISO, so we have a uniform format.
    /// But we can configure it changing date format, the response is using
    /// another format, so we can use our format rather than the ISO one
    @Operation(summary = "Get months starting with Sunday")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"), description = "Successfully retrieved months"),
            @ApiResponse(responseCode = "400", description = "Invalid date range provided",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InvalidDateRangeException.class)))
    })
    @GetMapping("/sundays")
    public List<String> getMonthsStartingWithSunday(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        return sundayCounterService.getMonthsStartingWithSunday(fromDate, toDate);
    }
}
