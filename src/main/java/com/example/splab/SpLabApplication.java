package com.example.splab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLabApplication {

    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.addContent(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.addContent(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.addContent(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.addContent(p4);
        System.out.println("Printing without Alignment");
        System.out.println();

        cap1.print();
        System.out.println("Printing with Alignment");
        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());
        cap1.print();
    }
}
