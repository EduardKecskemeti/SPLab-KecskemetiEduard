package com.example.splab.models;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Setter
    @Getter
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();
    @Transient
    private List<Element> elements = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Section> sections = new ArrayList<>();

    public void addSection(Section section) {
        if (!sections.contains(section)) {
            sections.add(section);
            section.setBook(this); // keep the bidirectional link consistent
        }
    }

    public Book() {}
    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.getBooks().add(this);
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public void addContent(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    @Override
    public void print() {
        System.out.println("\nBook: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println("Contents:");
        for (Element e : elements) {
            e.print();
        }
    }

}