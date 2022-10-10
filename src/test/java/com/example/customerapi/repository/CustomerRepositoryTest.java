package com.example.customerapi.repository;

import com.example.customerapi.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testFindByFirstNameOrLast() {
        assertEquals(0, this.customerRepository.findByFirstnameOrLastname("", "").size());
    }

    @Test
    void testFindByFirstNameOrLast1() {
        assertEquals(1, this.customerRepository.findByFirstnameOrLastname("Max", "").size());
    }

    @Test
    void testFindByFirstOrLastname2() {
        assertEquals(2, this.customerRepository.findByFirstnameOrLastname("", "Mustermann").size());
    }

    @Test
    void testFindByFirstOrLastname3() {
        assertEquals(3, this.customerRepository.findByFirstnameOrLastname("Lisa", "Mustermann").size());
    }

    @Test
    void testSave() {
        this.customerRepository.save(new Customer());
        assertEquals(5, this.customerRepository.findAll().size());
    }

    @Test
    void testFindAll() {
        assertEquals(4, this.customerRepository.findAll().size());
    }

}