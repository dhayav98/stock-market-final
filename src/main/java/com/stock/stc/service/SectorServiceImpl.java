package com.stock.stc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.stc.dao.SectorDao;
import com.stock.stc.model.Sector;

@Service
public class SectorServiceImpl implements SectorService {
	@Autowired
	SectorDao sectorDao;
	public Sector getSectorName(String name)
	{
		return  sectorDao.findByName(name);
	}
}
