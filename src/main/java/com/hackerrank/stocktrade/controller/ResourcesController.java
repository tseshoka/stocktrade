package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.controller.request.TradeResponseResource;
import com.hackerrank.stocktrade.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    @Autowired
    private TradesService service;

    @DeleteMapping()
    public ResponseEntity<TradeResponseResource> deleteAllTrades () {

        service.deleteAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
