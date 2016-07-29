package com.servie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	private User user = null;
	
	public User addUser(String username, String password,String firstName, String lastName){
		return userDao.addUser(username, password, firstName, lastName);
	}
	
	public User loginUser(int id, String password){
		
		user =  userDao.loginUser(id, password);
		System.out.println("Hello");
		System.out.println(user.getFirstName());
		if(id == user.getId() && password.equals(user.getPassword())){
		return user;
		}
		return null;
		
	}

}
