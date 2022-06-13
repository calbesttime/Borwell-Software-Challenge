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
        final CalcDto calcDto = buildCalcDto(dimensions);
        //When
        double area = paintCalcService.calcArea(calcDto);
        //Then
        Assert.assertEquals(15, area, 0.0);
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
        final CalcDto calcDto = buildCalcDto(dimensions);

        double area = paintCalcService.calcArea(calcDto);

        Assert.assertEquals(314, area, 0.0);
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
        final CalcDto calcDto = buildCalcDto(dimensions);

        double area = paintCalcService.calcArea(calcDto);

        Assert.assertEquals(13, area, 0.0);
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
        // "shape" == 4.0 while the room is a cuboid with 2 missing corners
        dimensions.put("shape", 4.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("corner1Len", corner1Len);
        dimensions.put("corner1Wid", corner1Wid);
        dimensions.put("corner2Len", corner2Len);
        dimensions.put("corner2Wid", corner2Wid);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double area = paintCalcService.calcArea(calcDto);


        Assert.assertEquals(12, area, 0.0);
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
        final CalcDto calcDto = buildCalcDto(dimensions);

        double amount = paintCalcService.calcAmount(calcDto);

        Assert.assertEquals(48, amount, 0.0);
    }

    @Test
    public void amount_should_be_188_point_4_L_if_the_room_is_a_cylinder_with_a_radius_of_10m_and_a_height_of_3m() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cylinder";
        final double radius = 10;
        final double height = 3;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 2.0 while the room is a cylinder
        dimensions.put("shape", 2.0);
        dimensions.put("radius", radius);
        dimensions.put("height", height);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double amount = paintCalcService.calcAmount(calcDto);

        Assert.assertEquals(188.4, amount, 0.0);
    }

    @Test
    public void amount_should_be_48L_if_the_room_is_a_3mx5mx3m_cuboid_with_a_1mx2m_missing_corner() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid_with_1_missing_corner";
        final double length = 5;
        final double width = 3;
        final double height = 3;
        // The dimensions of the rectangular missing corner will not affect the amount of paint required.
        // So we do not need to test the amount of the paint required to paint the walls of a cuboid room with 2 rectangular missing corners
        final double corner1Len = 2;
        final double corner1Wid = 1;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 3.0 while the room is a cuboid with 1 missing corner
        dimensions.put("shape", 3.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("height", height);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double amount = paintCalcService.calcAmount(calcDto);

        Assert.assertEquals(48, amount, 0.0);
    }

    /* --- Tests for calculating the amount of the paint required to paint the walls ends --- */


    /* --- Tests for calculating the volume of the room --- */

    @Test
    public void volume_should_be_45m3_if_the_room_is_a_3mx5mx3m_cuboid() {
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
        final CalcDto calcDto = buildCalcDto(dimensions);

        double volume = paintCalcService.calcVolume(calcDto);

        Assert.assertEquals(45, volume, 0.0);
    }

    @Test
    public void volume_should_be_942m3_if_the_room_is_a_cylinder_with_a_radius_of_10m_and_a_height_of_3m() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cylinder";
        final double radius = 10;
        final double height = 3;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 2.0 while the room is a cylinder
        dimensions.put("shape", 2.0);
        dimensions.put("radius", radius);
        dimensions.put("height", height);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double volume = paintCalcService.calcVolume(calcDto);

        Assert.assertEquals(942, volume, 0.0);
    }

    @Test
    public void amount_should_be_36m3_if_the_room_is_a_3mx5mx3m_cuboid_with_2mx1m_and_1mx1m_missing_corners() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid_with_1_missing_corner";
        final double length = 5;
        final double width = 3;
        final double height = 3;
        final double corner1Len = 2;
        final double corner1Wid = 1;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 4.0 while the room is a cuboid with 2 missing corners
        dimensions.put("shape", 4.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("height", height);
        dimensions.put("corner1Len", corner1Len);
        dimensions.put("corner1Wid", corner1Wid);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double volume = paintCalcService.calcVolume(calcDto);

        Assert.assertEquals(36, volume, 0.0);
    }

    @Test
    public void amount_should_be_39m3_if_the_room_is_a_3mx5mx3m_cuboid_with_a_1mx2m_missing_corner() {
        final PaintCalcService paintCalcService = new PaintCalcService();
        final String shape = "cuboid_with_1_missing_corner";
        final double length = 5;
        final double width = 3;
        final double height = 3;
        final double corner1Len = 2;
        final double corner1Wid = 1;
        final double corner2Len = 1;
        final double corner2Wid = 1;
        HashMap<String, Double> dimensions = new HashMap<>();
        // "shape" == 4.0 while the room is a cuboid with 2 missing corners
        dimensions.put("shape", 4.0);
        dimensions.put("length", length);
        dimensions.put("width", width);
        dimensions.put("height", height);
        dimensions.put("corner1Len", corner1Len);
        dimensions.put("corner1Wid", corner1Wid);
        dimensions.put("corner2Len", corner2Len);
        dimensions.put("corner2Wid", corner2Wid);
        final CalcDto calcDto = buildCalcDto(dimensions);

        double volume = paintCalcService.calcVolume(calcDto);

        Assert.assertEquals(39, volume, 0.0);
    }


    private CalcDto buildCalcDto(HashMap dimensions) {
        CalcDto calcDto = new CalcDto();
        if (dimensions.get("shape").equals(1.0)) {
            calcDto.setShape((Double) dimensions.get("shape"));
            calcDto.setLen((Double) dimensions.get("length"));
            calcDto.setWid((Double) dimensions.get("width"));
            if (dimensions.containsKey("height")) {
                calcDto.setHeight((Double) dimensions.get("height"));
            }
        } else if (dimensions.get("shape").equals(2.0)) {
            calcDto.setShape((Double) dimensions.get("shape"));
            calcDto.setRadius((Double) dimensions.get("radius"));
            if (dimensions.containsKey("height")) {
                calcDto.setHeight((Double) dimensions.get("height"));
            }
        } else if (dimensions.get("shape").equals(3.0)) {
            calcDto.setShape((Double) dimensions.get("shape"));
            calcDto.setLen((Double) dimensions.get("length"));
            calcDto.setWid((Double) dimensions.get("width"));
            if (dimensions.containsKey("height")) {
                calcDto.setHeight((Double) dimensions.get("height"));
            }
            if (dimensions.containsKey("corner1Len")) {
                calcDto.setCorner1Len((Double) dimensions.get("corner1Len"));
            }
            if (dimensions.containsKey("corner1Wid")) {
                calcDto.setCorner1Wid((Double) dimensions.get("corner1Wid"));
            }
        } else if (dimensions.get("shape").equals(4.0)) {
            calcDto.setShape((Double) dimensions.get("shape"));
            calcDto.setLen((Double) dimensions.get("length"));
            calcDto.setWid((Double) dimensions.get("width"));
            if (dimensions.containsKey("height")) {
                calcDto.setHeight((Double) dimensions.get("height"));
            }
            if (dimensions.containsKey("corner1Len")) {
                calcDto.setCorner1Len((Double) dimensions.get("corner1Len"));
            }
            if (dimensions.containsKey("corner1Wid")) {
                calcDto.setCorner1Wid((Double) dimensions.get("corner1Wid"));
            }
            if (dimensions.containsKey("corner2Len")) {
                calcDto.setCorner2Len((Double) dimensions.get("corner2Len"));
            }
            if (dimensions.containsKey("corner2Wid")) {
                calcDto.setCorner2Wid((Double) dimensions.get("corner2Wid"));
            }
        }
        return calcDto;
    }
}
