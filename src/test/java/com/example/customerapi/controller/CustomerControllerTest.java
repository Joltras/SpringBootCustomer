package com.example.customerapi.controller;
import com.example.customerapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testGetAll() throws Exception {
        mvc.perform(
                        get("/customer/getAll")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCustomer() throws Exception {
        var customer = customerRepository.findAll().get(0);
        mvc.perform(get("/customer/" + customer.getCustomerId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is(customer.getFirstname())));
    }


    @Test
    void testGetByFirstOrLastName() throws Exception {
        var customer = customerRepository.findAll().get(0);
        mvc.perform(get("/customer/getByName/" + customer.getFirstname())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lastname", is(customer.getLastname())));
    }

    @Test
    void testAdd() throws Exception {
        mvc.perform(put("/customer/add")
                .contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateFirstName() throws Exception {
        var customer = customerRepository.findAll().get(0);
        mvc.perform(post("/customer/" + customer.getCustomerId() + "/Test")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void testDelete() throws Exception {
        var customer = customerRepository.findAll().get(0);
        mvc.perform(delete("/customer/" + customer.getCustomerId())).andExpect(status().isOk());
    }


}