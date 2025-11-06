package com.example.splab.models;

import jakarta.persistence.Entity;

@Entity
public class BookTable extends Element {
    private String something;

    public BookTable() {}

    public BookTable(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}
