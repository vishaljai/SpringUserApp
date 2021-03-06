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
	
	public User loginUser(String username, String password){
		user =  userDao.loginUser(username, password);
		return user;
		}
	
	public void updateUser(String firstName, String lastName, String password){
		userDao.updateUser(firstName, lastName,password);
		//return user;
	}
		
	}
