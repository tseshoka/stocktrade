package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.controller.TradeRequestResource;
import com.hackerrank.stocktrade.dao.TradesDto;

import java.util.List;

public interface TradesSevice {

    public TradesDto addNewTrade (TradeRequestResource requestResource);

    public TradesDto getTradeById (String id);

    public List<TradesDto> getAllTrades ();

    public TradesDto getTradeByUserId (String userID);
}
