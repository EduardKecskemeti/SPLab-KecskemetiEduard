package com.example.splab.models;

import jakarta.persistence.Entity;

@Entity
public class Image extends Element {
    private String url;

    public Image() {}  // JPA requires default constructor

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image: " + url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
