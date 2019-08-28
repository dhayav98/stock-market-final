package com.stock.stc.service;

import java.sql.SQLException;
import java.util.List;

import com.stock.stc.model.User;

public interface UserService {
	 public User registerUser(User user) throws SQLException, ClassNotFoundException ;
	 public User updateUser(User user)throws Exception;
	 public List<User> getUserList() throws SQLException;

	 
}
