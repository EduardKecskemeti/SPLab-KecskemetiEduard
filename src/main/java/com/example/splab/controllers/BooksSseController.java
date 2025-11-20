package com.example.splab.controllers;

import com.example.splab.observer.AllBooksSubject;
import com.example.splab.observer.SseObserver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(0L); // never timeout
        allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }
}