package com.stock.stc.service;

import java.util.List;

import com.stock.stc.model.StockExchange;

public interface StockExchangeService {

	public StockExchange insertStockExchange(StockExchange stockexchange) throws Exception;
	public StockExchange updateStockExchange(StockExchange stockexchange) throws Exception;
	public List<StockExchange> getStockExchangeList() throws Exception;
}
