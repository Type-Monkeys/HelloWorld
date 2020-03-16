package com.typemonkeys.helloworld;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GreetingController.class)
@ComponentScan()
class GreetingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void Get_ShouldReturnOkay_WhenCalled() throws Exception {
        mockMvc.perform(get("/v1/greetings")).andExpect(status().isOk());
    }
}