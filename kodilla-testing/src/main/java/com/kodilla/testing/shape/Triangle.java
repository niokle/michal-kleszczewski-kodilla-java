package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String shapeName = "Triangle";
    private double shapeHeight;
    private double shapeBase;

    public Triangle(double shapeHeight, double shapeBase) {
        this.shapeHeight = shapeHeight;
        this.shapeBase = shapeBase;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return (shapeHeight * shapeBase) / 2;
    }
}
