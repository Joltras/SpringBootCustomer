package com.example.customerapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CategoryController categoryController;

    @Test
    void testGetAll() throws Exception {
        mvc.perform(
                        get("/article/getAll")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}