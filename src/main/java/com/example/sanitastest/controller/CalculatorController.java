package com.example.sanitastest.controller;

import com.example.sanitastest.service.CalculatorService;
import io.corp.calculator.TracerAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    private TracerAPI tracerAPI;

    @PostMapping("/sum")
    public BigDecimal sum(@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        BigDecimal result = calculatorService.sum(num1, num2);
        tracerAPI.trace(result);
        return result;
    }

    @PostMapping("/substract")
    public BigDecimal substract(@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        BigDecimal result = calculatorService.substract(num1, num2);
        tracerAPI.trace(result);
        return result;
    }
}
