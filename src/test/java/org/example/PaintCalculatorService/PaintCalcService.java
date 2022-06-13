package org.example.PaintCalculatorService;

public class PaintCalcService {
    final private double pi = 3.14;
    final private double cuboid = 1.0;
    final private double cylinder = 2.0;
    final private double cuboidWith1MC = 3.0;
    final private double cuboidWith2MC = 4.0;
    final private double unitPaint = 1.0;

    public double calcArea(CalcAreaDto calcAreaDto) {
        if (calcAreaDto.getShape() == cuboid && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth();
        } else if (calcAreaDto.getShape() == cylinder && calcAreaDto.getRadius() > 0) {
            return pi * calcAreaDto.getRadius() * calcAreaDto.getRadius();
        } else if (calcAreaDto.getShape() == cuboidWith1MC && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0
                && calcAreaDto.getCorner1Len() > 0 && calcAreaDto.getCorner1Len() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth() - calcAreaDto.getCorner1Len() * calcAreaDto.getCorner1Wid();
        } else if (calcAreaDto.getShape() == cuboidWith2MC && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0
                && calcAreaDto.getCorner1Len() > 0 && calcAreaDto.getCorner1Len() > 0
                && calcAreaDto.getCorner2Len() > 0 && calcAreaDto.getCorner2Wid() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth() -
                    calcAreaDto.getCorner1Len() * calcAreaDto.getCorner1Wid() -
                    calcAreaDto.getCorner2Len()* calcAreaDto.getCorner2Wid();
        }
        return 0;
    }

    public double calcAmount(CalcAreaDto calcAreaDto) {
        if (calcAreaDto.getShape() == cuboid && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0
        && calcAreaDto.getHeight() > 0) {
            return unitPaint * 2 * (calcAreaDto.getLength() + calcAreaDto.getWidth()) * calcAreaDto.getHeight();
        }
        return 0;
    }
}
