package com.example.splab;

import com.example.splab.models.Book;
import com.example.splab.persistence.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryTestConfig {

    @Bean
    CommandLineRunner testRepo(BookRepository bookRepo) {
        return args -> {
            Book b = new Book("Spring Lab Test Book");
            bookRepo.save(b);
            System.out.println("Books in DB: " + bookRepo.count());
        };
    }
}
