package com.stock.stc.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.stc.dao.UserDao;
import com.stock.stc.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User registerUser(User user) throws SQLException, ClassNotFoundException  {
	
		return userDao.save(user);

	}

	
	public User updateUser(User user) throws Exception {
		return null;
	
	}


	@Override
	public List<User> getUserList() throws SQLException {
		
		return userDao.findAll();
	}



}
