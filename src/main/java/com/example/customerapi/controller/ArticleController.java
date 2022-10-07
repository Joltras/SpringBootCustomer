package com.example.customerapi.controller;
import com.example.customerapi.entity.Article;
import com.example.customerapi.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Rest controller for article entities.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    /**
     * Repository for article entities
     */
    private final ArticleRepository articleRepository;

    /**
     * Creates a new article controller object with the given repository.
     * @param articleRepository repository for article entities
     */
    public ArticleController(ArticleRepository articleRepository) {this.articleRepository = articleRepository;}

    /**
     * Returns all articles from the article repository.
     * @return list of all articles
     */
    @GetMapping("/getAll")
    public List<Article> getArticles() {return this.articleRepository.findAll();}

}
