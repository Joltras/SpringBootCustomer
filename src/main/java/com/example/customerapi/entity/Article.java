package com.example.customerapi.entity;

import javax.persistence.*;

/**
 * Objects of this class are representing articles.
 * An article object contains a name, a description, a price and a category.
 */
@Entity
public class Article {

    /**
     * Id of the article
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the article
     */
    private String name;

    /**
     * Description of the article
     */
    private String description;

    /**
     * Price of the article
     */
    private Double price;

    /**
     * Category of the article
     * An article can only belong to one category
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    /**
     * Creates a new article object.
     */
    public Article() {}

    /**
     * Creates a new article object with the given values.
     * @param name name for the article
     * @param description description of the article
     * @param price price for the article
     * @param category category for the article
     */
    public Article(String name, String description, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the name of the article.
     * @return name of the article
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the article.
     * @param name new name of the article
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the article.
     * @return description of the article
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of the article.
     * @param description new description for the article
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the article.
     * @return price of the article
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Changes the price of the article.
     * @param price new price for the article
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    /**
     * Changes the category of the article.
     * @param category new category for the article
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns the id of the article.
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Changes the id of the article.
     * @param id new id for the article
     */
    public void setId(Long id) {
        this.id = id;
    }
}
