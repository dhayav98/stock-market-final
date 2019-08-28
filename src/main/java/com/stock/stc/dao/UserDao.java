package com.stock.stc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stc.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
