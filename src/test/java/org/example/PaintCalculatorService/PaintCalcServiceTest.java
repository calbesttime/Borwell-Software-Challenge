package org.example.PaintCalculatorService;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PaintCalcServiceTest {

    /* --- Tests for calculating the area of the floor --- */
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
        dimensions.put("length", length);
        dimensions.put("width", width);
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
        dimensions.put("radius", radius);
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
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("corner1Len", corner1Len);
        dimensions.put("corner1Wid", corner1Wid);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);

        double area = paintCalcService.calcArea(calcAreaDto);

        Assert.assertEquals(13, area, 0);
    }

    @Test
    public void area_should_be_12m2_if_the_room_is_a_3m_by_5m_cuboid_with_2mx1m_and_1mx1m_missing_corners() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid_with_2_missing_corner";
        final double length = 5;
        final double width = 3;
        final double corner1Len = 2;
        final double corner1Wid = 1;
        final double corner2Len = 1;
        final double corner2Wid = 1;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 4.0 while the room is a cuboid with 2 missing corner
        dimensions.put("shape", 4.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("corner1Len", corner1Len);
        dimensions.put("corner1Wid", corner1Wid);
        dimensions.put("corner2Len", corner2Len);
        dimensions.put("corner2Wid", corner2Wid);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);

        double area = paintCalcService.calcArea(calcAreaDto);

        Assert.assertEquals(12, area, 0);
    }

    /* --- Tests for calculating the area of the floor ends --- */

    /* --- Tests for calculating the amount of the paint required to paint the walls --- */

    /* Assume 1L paint is required to paint 1m^2 wall*/
    @Test
    public void amount_should_be_48L_if_the_room_is_a_3mx5mx3m_cuboid() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid";
        final double length = 5;
        final double width = 3;
        final double height = 3;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 1.0 while the room is a cuboid
        dimensions.put("shape", 1.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("height", height);
        final CalcAreaDto calcAreaDto = buildCalcAreaDto(dimensions);

        double amount = paintCalcService.calcAmount(calcAreaDto);

        Assert.assertEquals(48, amount, 0);
    }

    @Test
    public void amount_should_be_188_point_4_() {
    }

    private CalcAreaDto buildCalcAreaDto(HashMap dimensions) {
        CalcAreaDto calcAreaDto = new CalcAreaDto();
        if (dimensions.get("shape").equals(1.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setLen((Double) dimensions.get("length"));
            calcAreaDto.setWid((Double) dimensions.get("width"));
            if (dimensions.containsKey("height")) {
                calcAreaDto.setHeight((Double) dimensions.get("height"));
            }
        } else if (dimensions.get("shape").equals(2.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setRadius((Double) dimensions.get("radius"));
        } else if (dimensions.get("shape").equals(3.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setLen((Double) dimensions.get("length"));
            calcAreaDto.setWid((Double) dimensions.get("width"));
            calcAreaDto.setCorner1Len((Double) dimensions.get("corner1Len"));
            calcAreaDto.setCorner1Wid((Double) dimensions.get("corner1Wid"));
        } else if (dimensions.get("shape").equals(4.0)) {
            calcAreaDto.setShape((Double) dimensions.get("shape"));
            calcAreaDto.setLen((Double) dimensions.get("length"));
            calcAreaDto.setWid((Double) dimensions.get("width"));
            calcAreaDto.setCorner1Len((Double) dimensions.get("corner1Len"));
            calcAreaDto.setCorner1Wid((Double) dimensions.get("corner1Wid"));
            calcAreaDto.setCorner2Len((Double) dimensions.get("corner2Len"));
            calcAreaDto.setCorner2Wid((Double) dimensions.get("corner2Wid"));
        }
        return calcAreaDto;
    }
}
