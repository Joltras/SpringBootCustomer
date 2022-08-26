package com.example.customerapi.controller;

import com.example.customerapi.entity.Article;
import com.example.customerapi.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/getAll")
    public List<Article> getArticles() {
        return this.articleRepository.findAll();
    }

}
