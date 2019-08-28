package com.stock.stc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.stc.model.Company;

public interface CompanyDao extends JpaRepository<Company, Integer>{
	List<Company> findBySectorId( int sectorId);
	Company findByCompanyName(String companyName);
	@Query("Select c.companyName From Company c where c.companyName like %:name%")
	List<String> companyNameMatchingList(String name);
}
