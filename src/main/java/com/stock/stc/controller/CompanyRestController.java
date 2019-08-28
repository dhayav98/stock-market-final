package com.stock.stc.controller;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stc.dao.CompanyDao;
import com.stock.stc.model.Company;
import com.stock.stc.service.CompanyService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyRestController {
@Autowired
CompanyService companyService;
@Autowired
CompanyDao companyDao;
@GetMapping("/matching_companies/{matchingName}")
public List<String>  matchingCompaniesList(@PathVariable("matchingName") String name)
{
 return companyService.getMatchingCompanies(name);
 
}
@RequestMapping(value="/company-list",method=RequestMethod.GET)
public List<Company> firstPage()
{
 
 return companyDao.findAll();
}

@PostMapping("/company-insert-page")
public void insert(@RequestBody Company company) throws ClassNotFoundException, SQLException
{
	companyService.insertCompany(company);
	
	
}
}

