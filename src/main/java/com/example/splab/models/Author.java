package com.example.splab.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public Author(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void print() {
        System.out.println("Author: " + name);
    }

    // Getters & setters
    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBooks() { return books; }

    public void setName(String name) { this.name = name; }
    public void setBooks(List<Book> books) { this.books = books; }
}
