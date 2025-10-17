package com.example.splab;

class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String context) {
        System.out.println("<<AlignCenter>> " + paragraph.getText() + " <<AlignCenter>>");
    }
}