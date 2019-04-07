package com.kaushaldev.tradeoffanalysis.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void of_shouldReturnValidPoint_whenValidInput() {
        double expectedX =1;
        double expectedY =1;

        Point p = Point.of(expectedX,expectedY);

        Assertions.assertEquals(expectedX, p.getX());
        Assertions.assertEquals(expectedX, p.getXValue());
        Assertions.assertEquals(expectedY, p.getY());
        Assertions.assertEquals(expectedY, p.getYValue());
    }

    @Test
    void getNormalized_shouldReturnNormalizedPoint_whenValidInput() {
        double expectedX =2;
        double expectedY =2;

        Point p = Point.of(expectedX,expectedY);
        Point normalizedP = p.getNormalized(1,1,3,3);

        // normalized value should  be : (2 - 1)/(3 - 1) = .5
        double expectedNormalizedValue = .5;

        Assertions.assertEquals(expectedX, normalizedP.getX());
        Assertions.assertEquals(expectedNormalizedValue, normalizedP.getXValue());
        Assertions.assertEquals(expectedY, normalizedP.getY());
        Assertions.assertEquals(expectedNormalizedValue, normalizedP.getYValue());
    }

    @Test
    void transform() {
        double expectedX =2;
        double expectedY =2;
        double transformedX = 1;
        double transformedY = 4;

        Point p = Point.of(expectedX,expectedY);
        Point normalizedP = p.transform(() -> transformedX, () -> transformedY);

        Assertions.assertEquals(expectedX, normalizedP.getX());
        Assertions.assertEquals(transformedX, normalizedP.getXValue());
        Assertions.assertEquals(expectedY, normalizedP.getY());
        Assertions.assertEquals(transformedY, normalizedP.getYValue());
    }
}