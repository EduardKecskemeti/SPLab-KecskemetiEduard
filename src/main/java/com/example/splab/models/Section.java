package com.example.splab.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Section extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    @Transient
    private List<Element> children = new ArrayList<>();

    public Section() {}

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void addContent(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element e : children) {
            e.print();
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Book getBook() { return book; }
    public void setBook(Book book) {
        this.book = book;
        if (!book.getSections().contains(this)) {
            book.getSections().add(this);
        }
    }
}
