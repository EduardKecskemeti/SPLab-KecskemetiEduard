package com.example.splab.observer;
import com.example.splab.models.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(Book book);
}