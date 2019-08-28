package com.stock.stc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.stc.dao.CompanyDao;
import com.stock.stc.model.Company;
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	
	public Company insertCompany(Company company) throws SQLException, ClassNotFoundException {
		
		return companyDao.save(company);
	}

	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Company> getCompanyList() throws SQLException {
		return companyDao.findAll();
	}
	
	public List<Company> getCompaniesByStockId(int id)
	{
		return companyDao.findBySectorId(id);
		
	}
	
	public List<String> getMatchingCompanies(String name)
	{
		return companyDao.companyNameMatchingList(name);
	}

}