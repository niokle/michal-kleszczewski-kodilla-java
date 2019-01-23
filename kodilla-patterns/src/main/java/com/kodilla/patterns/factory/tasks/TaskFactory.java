package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "Driving";
    public static final String PAINTING = "Painting";
    public static final String SHOPPING = "Shopping";

    public Task createTask(String task) {
        switch (task) {
            case DRIVING:
                return new DrivingTask("task 1", "warszawa", "przyjaciele");
            case PAINTING:
                return new PaintingTask("task 2", "czerwony", "obraz");
            case SHOPPING:
                return new ShoppingTask("task 3", "buty", 10.0);
                default:
                    return null;
        }
    }
}
