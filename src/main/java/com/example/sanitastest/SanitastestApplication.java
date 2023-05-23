package com.example.sanitastest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.sanitastest", "io.corp.calculator"})
public class SanitastestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanitastestApplication.class, args);
    }

}
