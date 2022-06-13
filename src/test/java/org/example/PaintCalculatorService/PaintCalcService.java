package org.example.PaintCalculatorService;

public class PaintCalcService {
    final private double pi = 3.14;
    final private double cuboid = 1.0;
    final private double cylinder = 2.0;

    final private double cuboidWith1MC = 3.0;
    public double calcArea(CalcAreaDto calcAreaDto) {
        if (calcAreaDto.getShape() == cuboid && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth();
        } else if (calcAreaDto.getShape() == cylinder && calcAreaDto.getRadius() > 0) {
            return pi * calcAreaDto.getRadius() * calcAreaDto.getRadius();
        } else if (calcAreaDto.getShape() == cuboidWith1MC && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0
                && calcAreaDto.getCorner1Len() > 0 && calcAreaDto.getCorner1Len() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth() - calcAreaDto.getCorner1Len() * calcAreaDto.getCorner1Wid();
        }
        return 0;
    }
}
