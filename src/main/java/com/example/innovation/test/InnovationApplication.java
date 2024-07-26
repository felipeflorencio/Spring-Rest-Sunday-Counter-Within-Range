package com.example.innovation.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InnovationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovationApplication.class, args);
	}

}
