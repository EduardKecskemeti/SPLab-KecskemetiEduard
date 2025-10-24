package com.example.splab.models;
import java.util.ArrayList;
import java.util.List;
public class Paragraph extends Element {
    private String text;
    private AlignStrategy alignStrategy;
    private static final int LINE_WIDTH = 40; // configurable width

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void print() {
        // Split text into lines based on the width
        List<String> lines = wrapText(text, LINE_WIDTH);

        for (String line : lines) {
            if (alignStrategy != null) {
                // Apply alignment to each line separately
                alignStrategy.renderLine(line, LINE_WIDTH);
            } else {
                // Default (no alignment)
                System.out.println(line);
            }
        }
    }

    // Utility: split text into words that fit the LINE_WIDTH
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
