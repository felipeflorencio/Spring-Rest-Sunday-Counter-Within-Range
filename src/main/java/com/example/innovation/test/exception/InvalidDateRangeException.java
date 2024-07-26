package com.example.innovation.test.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class InvalidDateRangeException extends RuntimeException {

    @Schema(description = "Error message", example = "The provided date range is invalid: 'from' date is after 'to' date.")

    private final String details;
    public InvalidDateRangeException(String message, String details) {
        super(message);
        log.warn(message); /// This is only for demonstration purpose we can customise the error for example
        this.details = details;
    }
}
