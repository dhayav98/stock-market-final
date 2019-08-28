package com.stock.stc.controller;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.stock.stc.model.User;
import com.stock.stc.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

@GetMapping("/user-list")
public List<User> userlist() throws SQLException
{
 
 return userService.getUserList();
}

@PostMapping("/user-registration-page")
public void insert(@RequestBody User user) throws ClassNotFoundException, SQLException
{
	 user.setUserType("USER");
	 userService.registerUser(user);
	
}
}

