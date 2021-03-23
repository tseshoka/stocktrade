package com.hackerrank.stocktrade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    @DeleteMapping(value = "erase")
    public ResponseEntity<?> deleteAllTrades () {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
