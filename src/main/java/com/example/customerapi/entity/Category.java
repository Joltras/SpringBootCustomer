package com.example.customerapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    private String name;

    @Id
    private String abbreviation;

    public Category() {

    }

    public Category(String name, String abbreviation) {
    	this.name = name;
    	this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
