package com.kaushaldev.tradeoffanalysis.entities;

import java.util.Comparator;

public class PointXAxisComparator implements Comparator<Point> {
    public int compare(Point o1, Point o2) {
        int result;

        if( o1 == null) {
            result = -1;
        } else if (o2 == null) {
            result = 1;
        } else {
            result = Double.compare(o1.getXValue(), o2.getXValue());
        }

        return result;
    }
}
