package com.hackerrank.stocktrade.dao;

import com.hackerrank.stocktrade.controller.request.StockPriceResponse;
import com.hackerrank.stocktrade.controller.request.TradeRequestResource;
import com.hackerrank.stocktrade.controller.request.TradeResponseResource;
import com.hackerrank.stocktrade.model.Trade;

import java.util.ArrayList;
import java.util.List;

public class TradesDtoMapper {

    public TradesDto mapFromRequest (TradeRequestResource resource) {

        TradesDto dto = new TradesDto();
        dto.setId(resource.getId());
        dto.setPrice(resource.getPrice());
        dto.setTimestamp(resource.getTimestamp());
        dto.setShares(resource.getShares());
        dto.setUser(resource.getUser());
        dto.setSymbol(resource.getSymbol());
        dto.setType(resource.getType());

        return dto;
    }

    public TradeResponseResource mapToResponse (TradesDto dto) {

        TradeResponseResource resource = null;
        if (dto != null) {

            resource = new TradeResponseResource();

            resource.setId(dto.getId());
            resource.setPrice(dto.getPrice());
            resource.setTimestamp(dto.getTimestamp());
            resource.setShares(dto.getShares());
            resource.setUser(dto.getUser());
            resource.setSymbol(dto.getSymbol());
            resource.setType(dto.getType());
        }

        return resource;
    }

    public TradesDto mapFromModel (Trade trade) {

        TradesDto dto = null;
        if (trade != null) {

            dto = new TradesDto();

            dto.setId(trade.getId());
            dto.setPrice(trade.getPrice());
            dto.setTimestamp(trade.getTimestamp());
            dto.setShares(trade.getShares());
            dto.setUser(trade.getUser());
            dto.setSymbol(trade.getSymbol());
            dto.setType(trade.getType());
        }

        return dto;
    }

    public Trade mapToModel (TradesDto dto) {

        Trade trade = new Trade();
        trade.setId(dto.getId());
        trade.setPrice(dto.getPrice());
        trade.setTimestamp(dto.getTimestamp());
        trade.setShares(dto.getShares());
        trade.setUser(dto.getUser());
        trade.setSymbol(dto.getSymbol());
        trade.setType(dto.getType());

        return trade;
    }

    public List<TradesDto> mapFromModel (List<Trade> trades) {

        List<TradesDto> dtoList = new ArrayList<>();

        for (Trade trade: trades) {
            TradesDto dto = mapFromModel(trade);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public List<TradeResponseResource> mapToResponse (List<TradesDto> dtoList) {

        List<TradeResponseResource> responseResources = new ArrayList<>();

        for (TradesDto dto: dtoList) {
            TradeResponseResource responseResource = mapToResponse(dto);
            responseResources.add(responseResource);
        }

        return responseResources;
    }

    public StockPriceResponse mapFrom (StockPriceDto dto) {

        StockPriceResponse response = null;
        if (dto != null) {
            response = new StockPriceResponse();

            response.setHighest(dto.getHighest());
            response.setLowest(dto.getLowest());
            response.setSymbol(dto.getSymbol());
        }

        return response;
    }
}
