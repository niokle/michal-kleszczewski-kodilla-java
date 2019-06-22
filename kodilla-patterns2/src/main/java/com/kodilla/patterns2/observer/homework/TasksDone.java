package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TasksDone implements Observable {
    private final List<Observer> observers;
    private final String owner;
    private final List<Task> tasks;

    public TasksDone(String owner) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.owner = owner;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObserver();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public String getOwner() {
        return owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
