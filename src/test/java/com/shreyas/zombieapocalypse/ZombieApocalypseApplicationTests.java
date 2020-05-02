package com.shreyas.zombieapocalypse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
class ZombieApocalypseApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }
}