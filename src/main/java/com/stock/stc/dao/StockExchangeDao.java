package com.stock.stc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stc.model.StockExchange;

public interface StockExchangeDao extends JpaRepository<StockExchange, Integer> {

}
