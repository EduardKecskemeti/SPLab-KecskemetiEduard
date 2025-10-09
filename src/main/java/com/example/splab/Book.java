package com.example.splab;


import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private TableOfContents tableOfContents = new TableOfContents();
    private List<Chapter> chapters = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Author author : authors) {
            author.print();
        }
        tableOfContents.print();
        for (Chapter chapter : chapters) {
            chapter.print();
        }
    }
}
