package org.example.PaintCalculatorService;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PaintCalcServiceTest {

    @Test
    public void area_should_be_15m2_if_the_room_floor_is_a_3m_by_5m_rectangular() {
        //Given
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid";
        final double length = 5;
        final double width = 3;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 1.0 while the room is a cuboid
        dimensions.put("shape", 1.0);
        dimensions.put("length", 5.0);
        dimensions.put("width", 3.0);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);
        //When
        double area = paintCalcService.calcArea(calcAreaDto);
        //Then
        Assert.assertEquals(15, area, 0);
    }

    @Test
    public void area_should_be_314m2_if_the_room_is_a_cylinder_with_a_radius_of_10m() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cylinder";
        final double radius = 10;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 2.0 while the room is a cylinder
        dimensions.put("shape", 2.0);
        dimensions.put("radius", 10.0);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);

        double area = paintCalcService.calcArea(calcAreaDto);

        Assert.assertEquals(314, area, 0);
    }

    @Test
    public void area_should_be_13m2_if_the_room_is_a_3m_by_5m_cuboid_with_a_2m_by_1m_missing_corner() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid_with_1_missing_corner";
        final double length = 5;
        final double width = 3;
        final double corner1Len = 2;
        final double corner1Wid = 1;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 3.0 while the room is a cuboid with 1 missing corner
        dimensions.put("shape", 3.0);
        dimensions.put("length", 5.0);
        dimensions.put("width", 3.0);
        dimensions.put("corner1Len", 2.0);
        dimensions.put("corner1Wid", 1.0);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);

        double area = paintCalcService.calcArea(calcAreaDto);

        Assert.assertEquals(13, area, 0);
    }

    private CalcAreaDto buildCalcAreaDto(HashMap dimensions) {
        CalcAreaDto calcAreaDto = new CalcAreaDto();
        if (dimensions.get("shape").equals(1.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setLen((Double) dimensions.get("length"));
            calcAreaDto.setWid((Double) dimensions.get("width"));
        } else if (dimensions.get("shape").equals(2.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setRadius((Double) dimensions.get("radius"));
        } else if (dimensions.get("shape").equals(3.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setLen((Double) dimensions.get("length"));
            calcAreaDto.setWid((Double) dimensions.get("width"));
            calcAreaDto.setCorner1Len((Double) dimensions.get("corner1Len"));
            calcAreaDto.setCorner1Wid((Double) dimensions.get("corner1Wid"));
        }
        return calcAreaDto;
    }
}
