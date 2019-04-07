package com.kaushaldev.tradeoffanalysis.algorithm;

import com.kaushaldev.tradeoffanalysis.entities.Point;
import com.kaushaldev.tradeoffanalysis.entities.Points;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KneeDetectionTest {

    @Test
    void getTradeOffPoint_should_findCorrectKnee_WhenKneePresent() {
        List<Point> input = new ArrayList<>();
        input.add(Point.of(1,1));
        input.add(Point.of(2,2));
        input.add(Point.of(3,3));
        input.add(Point.of(4,5));
        input.add(Point.of(5,7));
        input.add(Point.of(6,9));
        input.add(Point.of(7,13));
        input.add(Point.of(8,14));
        input.add(Point.of(9,14));
        input.add(Point.of(10,15));

        Point kneePoint = new KneeDetection().getTradeOffPoint(new Points(input));

        Assertions.assertEquals(7, kneePoint.getX());
    }
}