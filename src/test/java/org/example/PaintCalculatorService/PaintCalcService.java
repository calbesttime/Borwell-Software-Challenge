package org.example.PaintCalculatorService;

public class PaintCalcService {
    public double calcArea(CalcAreaDto calcAreaDto) {
        if (calcAreaDto.getShape() == 1.0 && calcAreaDto.getLength() > 0 && calcAreaDto.getWidth() > 0) {
            return calcAreaDto.getLength() * calcAreaDto.getWidth();
        }
        return 0;
    }
}
