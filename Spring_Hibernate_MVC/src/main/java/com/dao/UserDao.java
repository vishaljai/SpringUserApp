package com.dao;

import com.entity.User;

public interface UserDao {
	
	User addUser(String username, String firstName, String lastName, String password);
	User loginUser(String username, String password);
	void updateUser(String firstName, String lastName, String password);

}
