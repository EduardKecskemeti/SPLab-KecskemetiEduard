package com.example.splab.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final List<Map<String, Object>> books = new ArrayList<>();

    // GET /books
    @GetMapping
    public List<Map<String, Object>> getAllBooks() {
        System.out.println("Returning all books...");
        return books;
    }

    // GET /books/{id}
    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable int id) {
        System.out.println("Returning book with ID " + id);
        return books.stream()
                .filter(b -> (int)b.get("id") == id)
                .findFirst()
                .orElse(Map.of("message", "Book not found"));
    }

    // POST /books
    @PostMapping
    public Map<String, Object> createBook(@RequestBody Map<String, Object> newBook) {
        System.out.println("Creating new book...");
        books.add(newBook);
        return Map.of("message", "Book created", "book", newBook);
    }

    // PUT /books/{id}
    @PutMapping("/{id}")
    public Map<String, Object> updateBook(@PathVariable int id, @RequestBody Map<String, Object> updatedBook) {
        System.out.println("Updating book with ID " + id);
        return Map.of("message", "Book updated", "id", id, "book", updatedBook);
    }

    // DELETE /books/{id}
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteBook(@PathVariable int id) {
        System.out.println("Deleting book with ID " + id);
        return Map.of("message", "Book deleted", "id", id);
    }
}
