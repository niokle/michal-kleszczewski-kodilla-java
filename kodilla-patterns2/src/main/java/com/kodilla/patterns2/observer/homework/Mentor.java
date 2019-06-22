package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int tasksCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTasksCount() {
        return tasksCount;
    }

    @Override
    public void update(TasksDone tasksDone) {
        System.out.println("Pojawiło się nowe zadanie od użytkownika: " + tasksDone.getOwner() +
                ", łączna ilość zadań tego użytkownika: " + tasksDone.getTasks().size());
        tasksCount++;
    }
}
