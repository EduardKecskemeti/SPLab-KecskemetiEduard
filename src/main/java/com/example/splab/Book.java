package com.example.splab;


import java.util.ArrayList;
import java.util.List;

class Book extends Element {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
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