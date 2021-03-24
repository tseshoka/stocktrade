package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.dao.TradesDto;
import com.hackerrank.stocktrade.model.Trade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradeRepository extends CrudRepository<Trade, Long> {

    Trade save(TradesDto tradesDto);

    Trade findTradeById(long id);

    List<Trade> findAll ();

    void deleteAll();

}
