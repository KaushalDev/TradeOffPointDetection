package com.kaushaldev.tradeoffanalysis.entities;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Points {
    private List<Point> pointList;

    public Points(final List<Point> pointList) {
        this.pointList = pointList;
        this.pointList.sort(new PointXAxisComparator());
    }

    public List<Point> getPointList() {
        return Collections.unmodifiableList(pointList);
    }

    public Points getNormalizedPoints() {
        double minX = this.pointList.stream().map(Point::getXValue).min(Double::compareTo).orElse(0d);
        double minY = this.pointList.stream().map(Point::getYValue).min(Double::compareTo).orElse(0d);
        double maxX = this.pointList.stream().map(Point::getXValue).max(Double::compareTo).orElse(0d);
        double maxY = this.pointList.stream().map(Point::getYValue).max(Double::compareTo).orElse(0d);

        List<Point> normalizedPoints = this.pointList
                                           .stream()
                                           .map(p -> p.getNormalized(minX, minY, maxX, maxY))
                                           .collect(Collectors.toList());

        return new Points(normalizedPoints);
    }

    public Points transform(final Function<Point, Double> xTransformFn, final Function<Point, Double> yTransformFn) {
        return  new Points(this.pointList
                               .stream()
                               .map(p -> p.transform(() -> xTransformFn.apply(p), () -> yTransformFn.apply(p)))
                               .collect(Collectors.toList()));
    }
}
