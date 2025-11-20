package com.example.splab.observer;

import com.example.splab.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }

    // custom method used by controller
    public void add(Book book) {
        notifyObservers(book);
    }
}