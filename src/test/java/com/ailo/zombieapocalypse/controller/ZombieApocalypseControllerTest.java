package com.ailo.zombieapocalypse.controller;


import com.ailo.zombieapocalypse.model.InputRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class ZombieApocalypseControllerTest extends AbstractTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void apocalypseTest() throws Exception {
        String uri = "/apocalypse";
        InputRequest inputRequest = new InputRequest(
                4,
                "(2,1)",
                "(0,1) (1,2) (3,1)",
                "DLUURR"
        );

        String inputJson = super.mapToJson(inputRequest);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"zombieScore\":3,\"zombiePosition\":\"(3,0) (2,1) (1,0) (0,0) \"}");
    }
}
