package com.example.sanitastest.configuration;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {
    @Bean
    public TracerImpl tracer() {
        return new TracerImpl();
    }
}
