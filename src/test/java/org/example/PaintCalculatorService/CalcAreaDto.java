package org.example.PaintCalculatorService;

public class CalcAreaDto {

    private double shape;
    private double length;
    private double width;

    private double radius;

    public void setShape(double shape) {
        this.shape = shape;
    }
    public void setLen(double length) {
        this.length = length;
    }

    public void setWid(double width) {
        this.width = width;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public double getShape() {
        return shape;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getRadius() {
        return radius;
    }
}
