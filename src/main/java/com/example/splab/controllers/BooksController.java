package com.example.splab.controllers;

import com.example.splab.models.Book;
import com.example.splab.persistence.BookRepository;
import com.example.splab.observer.AllBooksSubject;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BooksController {

    private final BookRepository bookRepository;
    private final AllBooksSubject allBooksSubject;

    public BooksController(BookRepository bookRepository, AllBooksSubject allBooksSubject) {
        this.bookRepository = bookRepository;
        this.allBooksSubject = allBooksSubject;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        Book saved = bookRepository.save(book);
        allBooksSubject.add(saved);
        return saved;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        book.setTitle(updatedBook.getTitle());
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "Deleted book with id " + id;
    }
}
