package com.kodilla.testing.shape;

public class Square implements Shape {
    private String shapeName = "Square";
    private double shapeSide;

    public Square(double shapeSide) {
        this.shapeSide = shapeSide;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return shapeSide * shapeSide;
    }
}
