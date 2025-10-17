package com.example.splab;

class AlignLeft implements AlignStrategy {
    @Override
    public void renderLine(String text, int width) {
        int spaces = width - text.length();
        if (spaces < 0) spaces = 0;
        System.out.println(text + " ".repeat(spaces));
    }
}
