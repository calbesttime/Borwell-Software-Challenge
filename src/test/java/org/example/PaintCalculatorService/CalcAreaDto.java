package org.example.PaintCalculatorService;

public class CalcAreaDto {

    private double shape;
    private double length;
    private double width;
    private double radius;
    private double corner1Len;
    private double corner1Wid;
    private double corner2Len;
    private double corner2Wid;

    public void setShape(double shape) {
        this.shape = shape;
    }
    public void setLen(double length) {
        this.length = length;
    }

    public void setWid(double width) {
        this.width = width;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCorner1Len(double corner1Len) {
        this.corner1Len = corner1Len;
    }

    public void setCorner1Wid(double corner1Wid) {
        this.corner1Wid = corner1Wid;
    }

    public void setCorner2Len(Double corner2Len) {
        this.corner2Len = corner2Len;
    }

    public void setCorner2Wid(Double corner2Wid) {
        this.corner2Wid = corner2Wid;
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

    public double getCorner1Len() {
        return corner1Len;
    }

    public double getCorner1Wid() {
        return corner1Wid;
    }

    public double getCorner2Len() {
        return corner2Len;
    }

    public double getCorner2Wid() {
        return corner2Wid;
    }
}
