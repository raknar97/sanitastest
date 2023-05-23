package com.example.sanitastest.controller;

import com.example.sanitastest.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    public BigDecimal sum(@RequestParam("num1") BigDecimal num1,@RequestParam("num2")BigDecimal num2){
        return calculatorService.sum(num1, num2);
    }
    @PostMapping("/substract")
    public BigDecimal substract(@RequestParam("num1") BigDecimal num1,@RequestParam("num2")BigDecimal num2){
        return calculatorService.substract(num1, num2);
    }
}
