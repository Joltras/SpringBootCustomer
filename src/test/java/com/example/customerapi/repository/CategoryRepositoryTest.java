package com.example.customerapi.repository;

import com.example.customerapi.entity.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeAll
    void setUp() {
        this.categoryRepository.save(new Category("A", "B"));
    }

    @Test
    void testGetByAbbNull() {
        assertNull(this.categoryRepository.findByAbbreviation("C"));
    }

    @Test
    void testGetByAbb() {
        assertNotNull(this.categoryRepository.findByAbbreviation("B"));
    }

    @Test
    void testSave() {
        this.categoryRepository.save(new Category("D", "d"));
        assertNotNull(this.categoryRepository.findByAbbreviation("d"));
    }

    @Test
    void testFindAll() {
        assertNotNull(this.categoryRepository.findAll());
    }

}