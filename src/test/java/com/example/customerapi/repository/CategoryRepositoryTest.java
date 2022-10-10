package com.example.customerapi.repository;

import com.example.customerapi.entity.Category;
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

    @Test
    void testGetByAbbNull() {
        assertNull(this.categoryRepository.findByAbbreviation("x"));
    }

    @Test
    void testGetByAbb() {
        assertNotNull(this.categoryRepository.findByAbbreviation("d"));
    }

    @Test
    void testSave() {
        this.categoryRepository.save(new Category("D", "d"));
        assertNotNull(this.categoryRepository.findByAbbreviation("d"));
    }

    @Test
    void testFindAll() {
        var list = this.categoryRepository.findAll();
        assertEquals(2, this.categoryRepository.findAll().size());
    }

}