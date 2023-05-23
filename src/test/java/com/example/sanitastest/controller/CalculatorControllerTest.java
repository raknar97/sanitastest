package com.example.sanitastest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {
    private final String calculatorPath = "/calculator";
    @Autowired
    private MockMvc mockMvc;


    @Test
    void sum() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post(calculatorPath + "/sum?num1=10&num2=20"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("30");
    }
}