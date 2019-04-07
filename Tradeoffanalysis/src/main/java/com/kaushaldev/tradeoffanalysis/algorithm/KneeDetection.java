package com.kaushaldev.tradeoffanalysis.algorithm;

import com.kaushaldev.tradeoffanalysis.entities.Point;
import com.kaushaldev.tradeoffanalysis.entities.Points;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KneeDetection implements TradeOffPointDetectionStrategy {
    @Override
    public Point getTradeOffPoint(Points points) {
        // Step 1 : normalize points
        Points normalizedPoints = points.getNormalizedPoints();

        // Step 2 : transform points to rate of change at x
        // x = x; y = y - x
        Points yChangeWithX = normalizedPoints.transform((Point p) -> p.getXValue(), (Point p) -> p.getYValue() - p.getXValue());

        // Step 3 : find places where rate of change is lesser than previous ones
        // x =x , y = y where y (i-1) < y (i) and y (i +1) < y (i)
        List<Point> yChangeWithXPoints = yChangeWithX.getPointList();

        List<Point>  decreasingYChangeWithX = IntStream.range(1, yChangeWithXPoints.size() - 1)
                                                 .filter(i -> (yChangeWithXPoints.get(i-1).getYValue() < yChangeWithXPoints.get(i).getYValue())
                                                              && (yChangeWithXPoints.get(i+1).getYValue() < yChangeWithXPoints.get(i).getYValue()))
                                                 .mapToObj(i -> yChangeWithXPoints.get(i))
                                                 .collect(Collectors.toList());

        // TODO : select point from threshold.

        return decreasingYChangeWithX.size() > 0 ? decreasingYChangeWithX.get(0) : null;
    }
}
