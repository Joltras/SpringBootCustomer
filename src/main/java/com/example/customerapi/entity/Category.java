package com.example.customerapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Objects of this class are representing categories for articles.
 * A category contains a name and an abbreviation.
 */
@Entity
public class Category {

    /**
     * Name of the category
     */
    private String name;

    /**
     * Abbreviation of the category
     */
    @Id
    private String abbreviation;

    /**
     * Creates a new category object
     */
    public Category() {}

    /**
     * Create a new category object with the given values.
     * @param name name for the category
     * @param abbreviation abbreviation for the category
     */
    public Category(String name, String abbreviation) {
    	this.name = name;
    	this.abbreviation = abbreviation;
    }

    /**
     * Returns the name of the category.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the category.
     * @param name new name for the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the abbreviation of the category.
     * @return abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Changes the abbreviation of the category.
     * @param abbreviation new abbreviation for the category
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
