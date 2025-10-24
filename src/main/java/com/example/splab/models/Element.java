package com.example.splab.models;

abstract class Element {
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
}