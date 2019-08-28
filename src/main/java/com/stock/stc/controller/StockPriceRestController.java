package com.stock.stc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stc.dao.CompanyDao;
import com.stock.stc.dao.SectorDao;
import com.stock.stc.dao.StockPriceDao;
import com.stock.stc.model.Company;
import com.stock.stc.model.Sector;
import com.stock.stc.model.StockPrice;

@RestController
public class StockPriceRestController {
	@Autowired
	CompanyDao companyDao;
	@Autowired
	StockPriceDao stockPriceDao;
	@Autowired
	SectorDao sectorDao;
//	@GetMapping("/stockpricedetails/{companyName}")
//	public List<StockPrice> stockPriceDetails(@PathVariable("companyName") String companyName)
//	{
//		Company companyDetails=companyDao.findByCompanyName(companyName);
//		List<StockPrice> stockPriceList=stockPriceDao.findByCompanyId(companyDetails.getCompanyId());
//		return stockPriceList;
//		
//	}
	
	@GetMapping("//stockpricedetails/{sectorName}")
	public List<StockPrice> stockPriceDetails(@PathVariable("sectorName") String sectorName)
	{
		Sector sector=sectorDao.findByName(sectorName);
        List<Company> companyList=companyDao.findBySectorId(sector.getId());
        List<StockPrice> stockPriceList =new ArrayList<>();
        for(Company company:companyList)
        {
               //System.out.println(company.getCompanyId());
        List<StockPrice> companyStock=stockPriceDao.findByCompanyId(company.getCompanyId());
               stockPriceList.addAll(companyStock);
        }
        return stockPriceList;

	}
}
