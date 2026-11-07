
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class AdditionControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new AdditionController())
                .build();
    }

    @Test
    public void testAdditionWithNegativeNumbers() throws Exception {

        mockMvc.perform(get("/ms1/add")
                .param("a", "-5")
                .param("b", "5"))

                .andExpect(status().isOk())
                .andExpect(content().string(
                        "MS 1.1 - Additon = 0"));
    }
}
