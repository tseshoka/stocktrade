package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.controller.TradeRequestResource;
import com.hackerrank.stocktrade.dao.TradesDto;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradesServiceImpl implements TradesSevice {

    @Override
    public TradesDto addNewTrade(TradeRequestResource requestResource) {


        return getTrade();
    }

    @Override
    public TradesDto getTradeById(String id) {

        return getTrade();
    }

    @Override
    public List<TradesDto> getAllTrades() {

        List<TradesDto> tradesDtos = new ArrayList<>();
        tradesDtos.add(getTrade());

        return tradesDtos;
    }

    @Override
    public TradesDto getTradeByUserId(String userID) {
        return getTrade();
    }

    public TradesDto getTrade () {

        TradesDto tradesDto = new TradesDto();
        tradesDto.setPrice(55f);
        tradesDto.setId(1l);
        tradesDto.setType("buy");
        tradesDto.setSymbol("AC");
        tradesDto.setTimestamp(new Timestamp(1616480520));

        return tradesDto;
    }
}
