package com.example.innovation.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SundayErrorResponse {

    private LocalDateTime timestamp;
    private String details;
    private String message;
}
