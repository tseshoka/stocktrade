package com.hackerrank.stocktrade.dao;

import lombok.Data;

@Data
public class StockPriceDto {

    private String symbol;
    private double highest;
    private double lowest;
}