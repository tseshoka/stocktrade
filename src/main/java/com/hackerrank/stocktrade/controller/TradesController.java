package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.dao.TradesDto;
import com.hackerrank.stocktrade.service.TradesSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

    //TODO RAN OUT OF TIME -- DTO should be response resource

    @Autowired
    TradesSevice tradesSevice;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TradesDto> addNewTrade (@RequestBody TradeRequestResource requestResource) {

        TradesDto tradesDto = tradesSevice.addNewTrade(requestResource);

        return new ResponseEntity<>(tradesDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TradesDto> getTradeById (@PathVariable String id) {

        TradesDto tradesDto  = tradesSevice.getTradeById(id);
        return new ResponseEntity<TradesDto>(tradesDto, HttpStatus.OK);
    }

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<TradesDto>> getAllTrades () {

        List<TradesDto> allTrades = tradesSevice.getAllTrades();

        return new ResponseEntity<List<TradesDto>>(allTrades, HttpStatus.OK); //Time constraints should retain response object
    }

    @GetMapping(value = "users/{userID}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TradesDto> getTradeByUserId (@PathVariable String userID) {

        TradesDto tradesDto = tradesSevice.getTradeByUserId(userID);

        return new ResponseEntity<>(tradesDto, HttpStatus.OK);
    }
}
