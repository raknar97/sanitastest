package com.example.sanitastest.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    public BigDecimal sum(BigDecimal n1, BigDecimal n2){
        return n1.add(n2);
    }
    public BigDecimal substract(BigDecimal n1, BigDecimal n2){
        return n1.subtract(n2);
    }

}
