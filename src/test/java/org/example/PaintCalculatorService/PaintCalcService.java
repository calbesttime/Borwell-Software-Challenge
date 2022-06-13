package org.example.PaintCalculatorService;

public class PaintCalcService {
    public double calcArea(CalcAreaDto calcAreaDto) {
        if (calcAreaDto.getShape() == 1.0 && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth();
        } else if (calcAreaDto.getShape() == 2.0 && calcAreaDto.getRadius() > 0) {
            return 3.14 * calcAreaDto.getRadius() * calcAreaDto.getRadius();
        }
        return 0;
    }
}
