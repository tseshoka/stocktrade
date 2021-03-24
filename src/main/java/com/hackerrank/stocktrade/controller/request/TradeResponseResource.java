package com.hackerrank.stocktrade.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackerrank.stocktrade.model.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TradeResponseResource {

    private Long id;
    private String type;
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
}
