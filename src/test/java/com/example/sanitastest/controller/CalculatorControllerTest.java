package com.example.sanitastest.controller;

import com.example.sanitastest.controller.handler.ErrorHandler;
import com.example.sanitastest.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

    @Test
    void substract() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post(calculatorPath + "/substract?num1=20&num2=10"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("10");
    }

    @Test
    void shouldThrowAControledExceptionWhenQueryParamsIncorrect() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post(calculatorPath + "/sum")
                        .param("num1", "test")
                        .param("num2", "20"))
                .andExpect(status().isBadRequest());

    }
}