package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TradeRequestResource {

    private Long id;
    private String type;
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    private Timestamp timestamp;
}
