package com.example.customerapi.repository;

import com.example.customerapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for category entities.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByAbbreviation(String abb);
}
