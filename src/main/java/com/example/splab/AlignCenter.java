package com.example.splab;

class AlignCenter implements AlignStrategy {
    @Override
    public void renderLine(String text, int width) {
        int totalSpaces = width - text.length();
        if (totalSpaces < 0) totalSpaces = 0;
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;
        System.out.println(" ".repeat(leftSpaces) + text + " ".repeat(rightSpaces));
    }
}