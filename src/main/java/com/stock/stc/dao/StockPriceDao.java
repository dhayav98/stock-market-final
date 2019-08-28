package com.stock.stc.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stock.stc.model.StockPrice;

public interface StockPriceDao extends JpaRepository<StockPrice, Integer> {
	
	List<StockPrice> findByCompanyId(int CompanyId);
	
	
	@Query("Select s from StockPrice s where s.companyId= :companyCode and s.date between :from_date and :to_date ")
		public List<StockPrice> getStockPrice(@Param("companyCode") int companyCode,@Param("from_date") Date from_date,@Param("to_date") Date to_date); 


}
