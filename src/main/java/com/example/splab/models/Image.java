package com.example.splab.models;

class Image extends Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image: " + url);
    }
}