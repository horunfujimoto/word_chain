package com.example.word_chain.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void resetTest() throws Exception {
        mockMvc.perform(
            get("/reset")
        )
        .andExpect(status().isOk());
    }

}
