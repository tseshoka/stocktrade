package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dao.StockPriceDto;
import com.hackerrank.stocktrade.dao.TradesDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TradesService {

    TradesDto addNewTrade (TradesDto tradesDto);

    TradesDto getTradeById (long id);

    List<TradesDto> getAllTrades ();

    List<TradesDto> getTradeByUserId (long userID);

    List<TradesDto> getAllTradesByStockSymbolAndTradeTypeInDateRange(String symbol, String type, LocalDateTime startDate, LocalDateTime endDate);

    StockPriceDto getHighestAndLowestPriceByStockSymbolInDateRange(String stockSymbol, LocalDateTime start, LocalDateTime endDate);

    void deleteAll();
}
