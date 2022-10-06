package com.example.customerapi.repository;

import com.example.customerapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for article entities.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {}

