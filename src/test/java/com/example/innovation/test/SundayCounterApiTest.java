package com.example.innovation.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SundayCounterApiTest {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testGetMonthsStartingWithSunday() {
        Response response = given()
                .queryParam("from", "1998-01-01")
                .queryParam("to", "2024-12-31")
                .when()
                .get("/sundays")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<String> months = response.jsonPath().getList("$");

        // Check specific months are in the response
        assertTrue(months.contains("February 1998"));
        assertTrue(months.contains("September 2024"));
    }

    @Test
    public void testInvalidDateRange() {
        given()
                .queryParam("from", "2023-01-01")
                .queryParam("to", "2022-12-31")
                .when()
                .get("/sundays")
                .then()
                .statusCode(400)
                .body("message", equalTo("The provided date range is invalid"));
    }
}
