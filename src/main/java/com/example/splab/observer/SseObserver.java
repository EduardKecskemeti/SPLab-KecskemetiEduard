package com.example.splab.observer;

import com.example.splab.models.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }
}