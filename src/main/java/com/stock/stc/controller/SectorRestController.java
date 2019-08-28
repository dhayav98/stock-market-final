package com.stock.stc.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.stock.stc.service.CompanyService;
import com.stock.stc.service.SectorService;

@RestController
public class SectorRestController {
	@Autowired
	CompanyDao companyDao;
	@Autowired
	CompanyService companyService;
	@Autowired
	SectorDao sectorDao;
	@Autowired
	SectorService sectorService;
	@Autowired
	StockPriceDao stockPriceDao;

	@GetMapping("/companieslist/{sectorName}")
	public List<Company> getCompaniesListByStockName(@PathVariable("sectorName") String sectorName) {
		Sector sectorid = sectorService.getSectorName(sectorName);
		return companyService.getCompaniesByStockId(sectorid.getId());
	}

	@GetMapping("/sectorprice/{sectorname}/{from}/{to}")
	List<StockPrice> getSectorPrice(@PathVariable("sectorname") String sectorName, @PathVariable("from") String from,@PathVariable("to") String to) throws ClassNotFoundException, SQLException, ParseException {
		DateFormat datefm = new SimpleDateFormat("dd-MM-yyyy");
		Sector sector = sectorDao.findByName(sectorName);

		List<Company> companyList = companyDao.findBySectorId(sector.getId());
		List<StockPrice> stockPriceList = new ArrayList<>();
		for (Company company : companyList) {

			List<StockPrice> companyStock = stockPriceDao.getStockPrice(company.getCompanyId(), datefm.parse(from),datefm.parse(to));
			stockPriceList.addAll(companyStock);
		}
		return stockPriceList;

	}

}
