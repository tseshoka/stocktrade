package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    //TODO RAN OUT OF TIME

    @GetMapping (value = "/trades/stocks/{stockSymbol}?type={tradeType}&start={startDate}&end={endDate}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trade> getStockTrades (@PathVariable String stockSymbol, @PathVariable String type,
                                                 @PathVariable String start, @PathVariable String endDate) {


        return new ResponseEntity<>(new Trade(), HttpStatus.OK);
    }

    @GetMapping (value = "/trades/stocks/{stockSymbol}?price?start={startDate}&end={endDate}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trade> getHighestAndLowestTrade (@PathVariable String stockSymbol, @PathVariable String price,
                                                           @PathVariable String start, @PathVariable String endDate) {



        return new ResponseEntity<>(new Trade(), HttpStatus.OK);
    }
}
