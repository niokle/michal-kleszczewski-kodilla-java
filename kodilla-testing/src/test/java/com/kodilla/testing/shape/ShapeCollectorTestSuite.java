package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

    @Test
    public void testGetShapeNameCircle() {
        String name = "Circle";
        Circle circle = new Circle(5);
        String result = circle.getShapeName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void testGetFieldCircle() {
        double radius = 5;
        Circle circle = new Circle(5);
        double field = Math.PI * radius * radius;
        double result = circle.getField();
        Assert.assertTrue(field == result);
    }

    @Test
    public void testGetShapeNameSquare() {
        String name = "Square";
        Square square = new Square(3);
        String result = square.getShapeName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void testGetFieldSquare() {
        double side = 3;
        Square square = new Square(side);
        double field = side * side;
        double result = square.getField();
        Assert.assertTrue(field == result);
    }

    @Test
    public void testGetShapeNameTriangle() {
        String name = "Triangle";
        Triangle triangle = new Triangle(3,5);
        String result = triangle.getShapeName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void testGetFieldTriangle() {
        double height = 3;
        double base = 5;
        Triangle triangle = new Triangle(height, base);
        double field = (height * base) / 2;
        double result = triangle.getField();
        Assert.assertTrue(field == result);
    }

    @Test
    public void testAddFigure() {
        Circle circle = new Circle(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(circle);
        Assert.assertEquals(1, shapeCollector.getNumberOfShapes());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        Circle circle = new Circle(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        boolean result = shapeCollector.removeFigure(circle);
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        Circle circle = new Circle(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(circle);
        boolean result = shapeCollector.removeFigure(circle);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        Circle circle = new Circle(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(circle);
        Shape shape = shapeCollector.getFigure(0);
        Assert.assertEquals(circle, shape);
    }

    @Test
    public void testShowFigures() {
        Circle circle = new Circle(5);
        Square square = new Square(4);
        Triangle triangle = new Triangle(2,3);
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList<Shape> shapes = new ArrayList<>();
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);
        shapes.add(circle);
        shapes.add(square);
        shapes.add(triangle);
        Assert.assertEquals(shapes, shapeCollector.showFigures());
    }
}
