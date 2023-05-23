package com.example.sanitastest.controller;

import com.example.sanitastest.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    @Autowired
    CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    };

    @PostMapping("/sum")
    public BigDecimal sum(@RequestParam("num1") BigDecimal num1,@RequestParam("num2")BigDecimal num2){
        return calculatorService.sum(num1, num2);
    }
}
