package com.example.splab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLabApplication {

    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("Stanga!");
        Paragraph p2 = new Paragraph("This is a longer paragraph that should automatically wrap around when it exceeds the fixed line width.");
        Paragraph p3 = new Paragraph("Somnic");

        cap1.addContent(p1);
        cap1.addContent(p2);
        cap1.addContent(p3);

        System.out.println("Without alignment:\n");
        cap1.print();

        p1.setAlignStrategy(new AlignLeft());
        p2.setAlignStrategy(new AlignCenter());
        p3.setAlignStrategy(new AlignRight());

        System.out.println("\nWith alignment:\n");
        cap1.print();
    }
    }

