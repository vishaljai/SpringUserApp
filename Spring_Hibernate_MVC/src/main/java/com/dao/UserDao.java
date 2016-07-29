package com.dao;

import com.entity.User;

public interface UserDao {
	
	User addUser(String username, String firstName, String lastName, String password);
	User loginUser(int id, String password);

}
