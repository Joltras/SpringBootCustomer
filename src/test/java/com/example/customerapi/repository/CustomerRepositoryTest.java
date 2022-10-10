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
        assertEquals(this.customerRepository.findByFirstnameOrLastname("", "").size(), 0);
    }

    @Test
    void testFindByFirstNameOrLast1() {
        assertEquals(this.customerRepository.findByFirstnameOrLastname("Max", "").size(), 1);
    }

    @Test
    void testFindByFirstOrLastname2() {
        assertEquals(this.customerRepository.findByFirstnameOrLastname("", "Mustermann").size(), 2);
    }

    @Test
    void testFindByFirstOrLastname3() {
        assertEquals(this.customerRepository.findByFirstnameOrLastname("Lisa", "Mustermann").size(), 3);
    }

    @Test
    void testSave() {
        this.customerRepository.save(new Customer());
        assertEquals(this.customerRepository.findAll().size(), 5);
    }

    @Test
    void testFindAll() {
        assertEquals(this.customerRepository.findAll().size(), 4);
    }

}