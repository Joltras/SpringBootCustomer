package com.example.customerapi.controller;
import com.example.customerapi.entity.Category;
import com.example.customerapi.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * A rest controller for category entities.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    /**
     * Repository for category entities
     */
    private final CategoryRepository categoryRepository;

    /**
     * Creates a new category controller object the given repository.
     * @param categoryRepository repository for category entities
     */
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Returns all categories from the category repository.
     * @return list of all categories
     */
    @GetMapping("/getAll")
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

}
