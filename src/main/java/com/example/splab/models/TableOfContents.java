package com.example.splab.models;

class TableOfContents extends Element {
    private String something;

    public TableOfContents(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents: " + something);
    }
}
