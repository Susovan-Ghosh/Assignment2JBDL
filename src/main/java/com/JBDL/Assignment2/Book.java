package com.JBDL.Assignment2;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
    private String name;
    private String author_name;
    private int cost;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
