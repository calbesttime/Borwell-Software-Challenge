package org.example.PaintCalculatorService;

public class PaintCalcService {
    final private double pi = 3.14;
    final private double cuboid = 1.0;
    final private double cylinder = 2.0;
    final private double cuboidWith1MC = 3.0;
    final private double cuboidWith2MC = 4.0;
    final private double unitPaint = 1.0;

    public double calcArea(CalcDto calcDto) {
        if (calcDto.getShape() == cuboid && calcDto.getLength() > 0 && calcDto.getWidth() > 0) {
            return calcDto.getLength() * calcDto.getWidth();
        } else if (calcDto.getShape() == cylinder && calcDto.getRadius() > 0) {
            return pi * calcDto.getRadius() * calcDto.getRadius();
        } else if (calcDto.getShape() == cuboidWith1MC && calcDto.getLength() > 0 && calcDto.getWidth() > 0
                && calcDto.getCorner1Len() > 0 && calcDto.getCorner1Len() > 0) {
            return calcDto.getLength() * calcDto.getWidth() - calcDto.getCorner1Len() * calcDto.getCorner1Wid();
        } else if (calcDto.getShape() == cuboidWith2MC && calcDto.getLength() > 0 && calcDto.getWidth() > 0
                && calcDto.getCorner1Len() > 0 && calcDto.getCorner1Len() > 0
                && calcDto.getCorner2Len() > 0 && calcDto.getCorner2Wid() > 0) {
            return calcDto.getLength() * calcDto.getWidth() -
                    calcDto.getCorner1Len() * calcDto.getCorner1Wid() -
                    calcDto.getCorner2Len()* calcDto.getCorner2Wid();
        }
        return 0;
    }

    public double calcAmount(CalcDto calcDto) {
        if (calcDto.getShape() == cuboid && calcDto.getLength() > 0 && calcDto.getWidth() > 0
        && calcDto.getHeight() > 0) {
            return unitPaint * 2 * (calcDto.getLength() + calcDto.getWidth()) * calcDto.getHeight();
        }
        return 0;
    }
}
