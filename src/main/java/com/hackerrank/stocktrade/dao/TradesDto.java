package com.hackerrank.stocktrade.dao;

import com.hackerrank.stocktrade.model.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TradesDto {

    private Long id;
    private String type;
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    private Timestamp timestamp;
}
