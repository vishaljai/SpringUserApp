package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sf;
	
	private User user = null;
	
	public User addUser(String username, String firstName, String lastName, String password){
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		user = new User(username,firstName,lastName,password);
		session.save(user);
		transaction.commit();
		session.close();
		return user;
	}

	public User loginUser(int id, String password) {
		
		int userId;
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		userId = user.getId();
		//session.get()
		transaction.commit();
		session.close();
		return user;
	}

}
