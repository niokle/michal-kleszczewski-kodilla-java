package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String shapeName = "Circle";
    private double shapeRadius;

    public Circle(double shapeRadius) {
        this.shapeRadius = shapeRadius;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return Math.PI * shapeRadius * shapeRadius;
    }
}
