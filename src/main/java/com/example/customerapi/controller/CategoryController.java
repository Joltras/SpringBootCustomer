package com.example.customerapi.controller;

import com.example.customerapi.entity.Category;
import com.example.customerapi.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/getAll")
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

}
