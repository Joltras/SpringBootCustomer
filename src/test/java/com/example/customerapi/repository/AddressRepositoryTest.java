package com.example.customerapi.repository;

import com.example.customerapi.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    void testFindByCity() {
        assertEquals(2, this.addressRepository.findByCity("Test City").size());
    }

    @Test
    void testCountAddressByCity() {
        assertEquals(1, this.addressRepository.countAddressByCity("City3"));
    }

    @Test
    void testFindByStreet() {
        assertEquals(2, this.addressRepository.findByStreetOrderByCity("Street2").size());
    }

    @Test
    void testSave() {
        this.addressRepository.save(new Address());
        assertEquals(4, this.addressRepository.findAll().size());
    }

    @Test
    void testFindAll() {
        assertEquals(3, this.addressRepository.findAll().size());
    }

}