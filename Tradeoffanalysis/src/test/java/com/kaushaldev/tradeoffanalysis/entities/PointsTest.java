package com.kaushaldev.tradeoffanalysis.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @Test
    void getNormalizedPoints_shouldReturnNormalizedPoints_WhenValidInput() {
        List<Point> input = new ArrayList<>();
        input.add(Point.of(1,1));
        input.add(Point.of(2,2));
        input.add(Point.of(3,3));

        Points normalizedPoints = new Points(input).getNormalizedPoints();

        List<Point> normalizedPointList = normalizedPoints.getPointList();

        assertEquals(input.size(), normalizedPointList.size());
        assertPoint(normalizedPointList.get(0), 0, 0, input.get(0).getX(), input.get(0).getY());
        assertPoint(normalizedPointList.get(1), .5, .5, input.get(1).getX(), input.get(1).getY());
        assertPoint(normalizedPointList.get(2), 1, 1, input.get(2).getX(), input.get(2).getY());
    }

    @Test
    void transform_shouldReturnTransformedPoints_whenValidInput() {
        List<Point> input = new ArrayList<>();
        input.add(Point.of(1,1));
        input.add(Point.of(2,2));
        input.add(Point.of(3,3));

        Points transformedPoints = new Points(input).transform((Point p) -> p.getX() * 2d, (Point p) -> p.getY() * 3d);

        List<Point> transformedPointList = transformedPoints.getPointList();

        assertEquals(input.size(), transformedPointList.size());
        assertPoint(transformedPointList.get(0),
                input.get(0).getX() * 2,
                input.get(0).getY() * 3,
                input.get(0).getX(),
                input.get(0).getY());
        assertPoint(transformedPointList.get(1),
                input.get(1).getX() * 2,
                input.get(1).getY() * 3,
                input.get(1).getX(),
                input.get(1).getY());
        assertPoint(transformedPointList.get(2),
                input.get(2).getX() * 2,
                input.get(2).getY() * 3,
                input.get(2).getX(),
                input.get(2).getY());
    }

    private void assertPoint(Point p, double expectedXValue, double expectedYValue, double expectedX, double expectedY) {
        assertEquals(expectedXValue, p.getXValue());
        assertEquals(expectedX, p.getX());
        assertEquals(expectedYValue, p.getYValue());
        assertEquals(expectedY, p.getY());
    }
}