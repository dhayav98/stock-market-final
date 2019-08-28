package com.stock.stc.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stc.model.IpoDetail;

public interface IpoDetailDao extends JpaRepository<IpoDetail, Integer> {

	List<IpoDetail> findByCompanyName(String companyName);

}
