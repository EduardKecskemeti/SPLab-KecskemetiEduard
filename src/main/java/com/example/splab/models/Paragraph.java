package com.example.splab.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Paragraph extends Element {

    private String text;

    @Transient  // not persisted, since it’s a runtime strategy
    private AlignStrategy alignStrategy;

    @Transient  // not persisted, just a constant
    private static final int LINE_WIDTH = 40;

    public Paragraph() {} // JPA requires a default constructor

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void print() {
        List<String> lines = wrapText(text, LINE_WIDTH);
        for (String line : lines) {
            if (alignStrategy != null) {
                alignStrategy.renderLine(line, LINE_WIDTH);
            } else {
                System.out.println(line);
            }
        }
    }

    private List<String> wrapText(String text, int width) {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > width) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                if (!currentLine.isEmpty()) currentLine.append(" ");
                currentLine.append(word);
            }
        }

        if (!currentLine.isEmpty()) {
            lines.add(currentLine.toString());
        }

        return lines;
    }

    @Override
    public void addContent(Element element) {
        // Not applicable for Paragraphs
    }

    @Override
    public void remove(Element element) {
        // Not applicable
    }

    @Override
    public Element get(int index) {
        return null;
    }
}
