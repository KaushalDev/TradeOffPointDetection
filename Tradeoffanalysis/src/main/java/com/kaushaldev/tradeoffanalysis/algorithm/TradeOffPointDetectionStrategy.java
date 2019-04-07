package com.kaushaldev.tradeoffanalysis.algorithm;

import com.kaushaldev.tradeoffanalysis.entities.Point;
import com.kaushaldev.tradeoffanalysis.entities.Points;

public interface TradeOffPointDetectionStrategy {
    Point getTradeOffPoint(Points points);
}
