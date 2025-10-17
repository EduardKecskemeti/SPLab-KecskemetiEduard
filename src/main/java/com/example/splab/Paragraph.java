package com.example.splab;

class Paragraph extends Element {
    private String text;
    private AlignStrategy alignStrategy = null;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    public String getText() {
        return text;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this, text);
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}
