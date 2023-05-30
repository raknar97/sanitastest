package com.example.sanitastest.controller;

import com.example.sanitastest.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableAutoConfiguration
public class CalculatorController {
    private final CalculatorService calculatorService;

    private final TracerImpl tracer;

    @PostMapping("/sum")
    public BigDecimal sum(@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        BigDecimal result = calculatorService.sum(num1, num2);
        tracer.trace(result);
        return result;
    }

    @PostMapping("/substract")
    public BigDecimal substract(@RequestParam("num1") BigDecimal num1, @RequestParam("num2") BigDecimal num2) {
        BigDecimal result = calculatorService.substract(num1, num2);
        tracer.trace(result);
        return result;
    }
}
