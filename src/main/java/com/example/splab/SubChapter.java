package com.example.splab;
import java.util.ArrayList;
import java.util.List;
class SubChapter {
    private String name;
    private List<Paragraph> paragraphs = new ArrayList<>();
    private List<Image> images = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();

    public SubChapter(String name) {
        this.name = name;
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void print() {
        System.out.println("SubChapter: " + name);
        for (Paragraph p : paragraphs) {
            p.print();
        }
        for (Image i : images) {
            i.print();
        }
        for (Table t : tables) {
            t.print();
        }
    }
}
