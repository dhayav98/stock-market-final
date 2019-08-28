package com.stock.stc.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stc.dao.IpoDetailDao;
import com.stock.stc.model.IpoDetail;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IpoDetailRestController {

@Autowired
IpoDetailDao ipoDetailsDao;
	
	@GetMapping("/ipo_details_list/{name}")
	public List<IpoDetail> ipo_details_by_name(@PathVariable("name") String companyName)
	{
		List<IpoDetail> ipodetailslist=ipoDetailsDao.findByCompanyName(companyName);
		return ipodetailslist;

	}
	@GetMapping("/ipo_details_list")
	public List<IpoDetail> ipo_details_list()
	{
		List<IpoDetail> ipodetailslist=ipoDetailsDao.findAll();
		for(IpoDetail item : ipodetailslist){
			System.out.println(item.getCompanyId());
		}
		return ipodetailslist;

	}
	
}
