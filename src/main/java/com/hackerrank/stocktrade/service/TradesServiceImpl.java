package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dao.StockPriceDto;
import com.hackerrank.stocktrade.dao.TradesDto;
import com.hackerrank.stocktrade.dao.TradesDtoMapper;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradesServiceImpl implements TradesService {

    @Autowired
    private TradeRepository tradeRepository;
    private final TradesDtoMapper tradesDtoMapper;

    public TradesServiceImpl () {

        this.tradesDtoMapper = new TradesDtoMapper();
    }

    @Override
    public TradesDto addNewTrade(TradesDto dto) {

        Trade trade = tradesDtoMapper.mapToModel(dto);
        return tradesDtoMapper.mapFromModel(tradeRepository.save(trade));
    }

    @Override
    public TradesDto getTradeById(long id) {

        return tradesDtoMapper.mapFromModel(tradeRepository.findTradeById(id));
    }

    @Override
    public List<TradesDto> getAllTrades() {

        return tradesDtoMapper.mapFromModel(tradeRepository.findAll());
    }

    @Override
    public List<TradesDto> getTradeByUserId(long userID) {

        List<TradesDto> trades = new ArrayList<>();

        for (Trade trade : tradeRepository.findAll()) {

            if(trade.getUser().getId().equals(userID)) {
                trades.add(tradesDtoMapper.mapFromModel(trade));
            }
        }

        return trades;
    }

    @Override
    public List<TradesDto> getAllTradesByStockSymbolAndTradeTypeInDateRange(String symbol, String type, LocalDateTime startDate, LocalDateTime endDate) {

        List<TradesDto> trades = new ArrayList<>();

        for (Trade trade : tradeRepository.findAll()) {

            if(trade.getSymbol().equalsIgnoreCase(symbol) && trade.getType().equalsIgnoreCase(type)
                && (trade.getTimestamp().toLocalDateTime().isAfter(startDate) && trade.getTimestamp().toLocalDateTime().isBefore(endDate.withHour(23).minusMinutes(59)))) {

                trades.add(tradesDtoMapper.mapFromModel(trade));
            }
        }

        return trades;
    }

    @Override
    public StockPriceDto getHighestAndLowestPriceByStockSymbolInDateRange(String stockSymbol, LocalDateTime start, LocalDateTime endDate) {

        List<TradesDto> trades = new ArrayList<>();
        StockPriceDto dto = new StockPriceDto();

        for (Trade trade : tradeRepository.findAll()) {

            if (trade.getSymbol().equalsIgnoreCase(stockSymbol) && (trade.getTimestamp().toLocalDateTime().isAfter(start) &&
                    trade.getTimestamp().toLocalDateTime().isBefore(endDate))) {
                trades.add(tradesDtoMapper.mapFromModel(trade));
            }
        }

        double highest = trades.get(0).getPrice();
        double lowest = trades.get(0).getPrice();

        for (TradesDto tradesDto: trades) {

            if (tradesDto.getPrice() >= highest) {
                highest = tradesDto.getPrice();
                dto.setHighest(highest);
                dto.setSymbol(tradesDto.getSymbol());
            }

            if (tradesDto.getPrice() <= lowest) {
                lowest = tradesDto.getPrice();
                dto.setLowest(lowest);
                dto.setSymbol(tradesDto.getSymbol());
            }
        }

        return dto;
    }

    @Override
    public void deleteAll() {
        tradeRepository.deleteAll();
    }
}
