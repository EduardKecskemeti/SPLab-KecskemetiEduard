package com.example.splab;

class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String context) {
        System.out.println(paragraph.getText() + " <<AlignRight>>");
    }
}
