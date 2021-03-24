package com.hackerrank.stocktrade.controller.request;

import lombok.Data;

@Data
public class StockPriceResponse {

    private String symbol;
    private double highest;
    private double lowest;
}
