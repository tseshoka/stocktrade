package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.controller.request.TradeRequestResource;
import com.hackerrank.stocktrade.controller.request.TradeResponseResource;
import com.hackerrank.stocktrade.dao.TradesDto;
import com.hackerrank.stocktrade.dao.TradesDtoMapper;
import com.hackerrank.stocktrade.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TradesController {

    TradesService service;
    TradesDtoMapper mapper;

    @Autowired
    public TradesController (TradesService service) {

        this.service = service;
        this.mapper = new TradesDtoMapper();
    }

    @PostMapping(value = "/trades",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TradeResponseResource> addNewTrade (@RequestBody TradeRequestResource requestResource) {

        TradesDto dto = service.getTradeById(requestResource.getId());
        if (dto != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        dto = mapper.mapFromRequest(requestResource);

        TradeResponseResource responseResource = mapper.mapToResponse(service.addNewTrade(dto));

        return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
    }

    @GetMapping(value = "trades/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TradeResponseResource> getTradeById (@PathVariable long id) {

        TradeResponseResource responseResource  = mapper.mapToResponse(service.getTradeById(id));

        if(responseResource == null) {
            return new ResponseEntity<>(responseResource, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping(value = "trades",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<TradeResponseResource>> getAllTrades () {

        List<TradeResponseResource> allTrades = mapper.mapToResponse(service.getAllTrades());

        if(allTrades.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allTrades, HttpStatus.OK);
    }

    @GetMapping(value = "/trades/users/{userID}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<TradeResponseResource>> getTradeByUserId (@PathVariable long userID) {

        List<TradeResponseResource> responseResource = mapper.mapToResponse(service.getTradeByUserId(userID));

        if(responseResource.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }

    @GetMapping(value = "/trades/stocks/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<TradeResponseResource>> getAllTradesByStockSymbolAndTradeTypeInDateRange (
            @PathVariable String symbol, @RequestParam String type, @RequestParam String start, @RequestParam String end) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end);

        List<TradesDto> dtoList = service.getAllTradesByStockSymbolAndTradeTypeInDateRange(symbol, type, startDate.atStartOfDay(), endDate.plusDays(1).atStartOfDay());
        List<TradeResponseResource> responseResource = mapper.mapToResponse(dtoList);

        if(responseResource.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(responseResource, HttpStatus.OK);
    }
}
