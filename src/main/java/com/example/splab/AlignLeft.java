package com.example.splab;

class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String context) {
        System.out.println("<<AlignLeft>> " + paragraph.getText());
    }
}
