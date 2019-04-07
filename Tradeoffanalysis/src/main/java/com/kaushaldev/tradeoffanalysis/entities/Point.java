package com.kaushaldev.tradeoffanalysis.entities;

import java.util.function.Supplier;

public class Point {
    private double xValue;

    private double yValue;

    private double x;

    private double y;

    private Point(final double x, final double y) {
        this(x, y, x, y);
    }

    private Point(final double xValue, final double yValue, final double x, final double y) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.x = x;
        this.y = x;
    }

    public static Point of(final double x, final double y) {
        return new Point(x, y);
    }

    public double getXValue() {
        return xValue;
    }

    public double getYValue() {
        return yValue;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point getNormalized(final double minX, final double minY, final double maxX, final double maxY) {
      return new Point(getNormalizedValue(xValue, minX, maxX), getNormalizedValue(yValue, minY, maxY), x, y);
    }

    public Point transform(final Supplier<Double> xValueSupplier, final Supplier<Double> yValueSupplier) {
        return new Point(xValueSupplier.get(), yValueSupplier.get(), x, y);
    }

    private double getNormalizedValue(final double actualValue, final double minValue, final double maxValue) {
        double result;

        double denominator = maxValue - minValue;

        if (denominator == 0) {
            result = 0;
        } else {
            result = (actualValue - minValue) / denominator;
        }

        return result;
    }
}
