package com.stock.stc.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stc.model.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer>
{
		Sector findByName(String name);


}
