package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.controller.request.StockPriceResponse;
import com.hackerrank.stocktrade.dao.StockPriceDto;
import com.hackerrank.stocktrade.dao.TradesDtoMapper;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class StocksController {

    @Autowired
    TradesService service;
    TradesDtoMapper mapper;

    public StocksController () {
        mapper = new TradesDtoMapper();
    }

    @GetMapping (value = "/stocks/{stockSymbol}?type={type}&start={start}&end={end}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trade> getStockTrades (@PathVariable String stockSymbol, @RequestParam String type,
                                                 @RequestParam String start, @RequestParam String endDate) {


        return new ResponseEntity<>(new Trade(), HttpStatus.OK);
    }

    @GetMapping (value = "/stocks/{stockSymbol}/price?start={start}&end={end}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockPriceResponse> getHighestAndLowestTrade (@PathVariable String stockSymbol,
                                                                        @RequestParam String start, @RequestParam String end) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end);

        StockPriceDto stockPriceDto = service.getHighestAndLowestPriceByStockSymbolInDateRange(stockSymbol,
                startDate.atStartOfDay(), endDate.plusDays(1).atStartOfDay());

        StockPriceResponse response = mapper.mapFrom(stockPriceDto);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
