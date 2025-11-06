package com.example.splab.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public abstract void print();

    public void addContent(Element element) {
        throw new UnsupportedOperationException("add() not supported");
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException("remove() not supported");
    }

    public Element get(int index) {
        throw new UnsupportedOperationException("get() not supported");
    }

    public int getId() {
        return id;
    }
}
