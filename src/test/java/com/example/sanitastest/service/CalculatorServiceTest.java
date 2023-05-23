package com.example.sanitastest.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorServiceTest {

    @Test
    void shouldSumUpTwoValues() {
        CalculatorService calculatorService = new CalculatorService();
        BigDecimal result = calculatorService.sum(new BigDecimal(1), new BigDecimal(2));

        assertThat(result).isEqualTo(new BigDecimal(3));
    }
    @Test
    void shouldSubstractTheGivenValues() {
        CalculatorService calculatorService = new CalculatorService();
        BigDecimal result = calculatorService.substract(new BigDecimal(20), new BigDecimal(10));

        assertThat(result).isEqualTo(new BigDecimal(10));
    }
}
