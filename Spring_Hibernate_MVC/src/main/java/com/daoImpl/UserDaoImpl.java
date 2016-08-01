package com.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.User;

@SuppressWarnings("deprecation")
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sf;
	
	//private User user = new User();
	
	public User addUser(String username, String firstName, String lastName, String password){
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		User user = new User(username,firstName,lastName,password);
		session.save(user);
		transaction.commit();
		session.close();
		return user;
	}

	public User loginUser(String username, String password) {
		
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		@SuppressWarnings("rawtypes")
		Query hquery = session.createQuery("from User where password = :password and username = :username"); //<- password is a sha1 hash in the db
		hquery.setString("username", username);
		hquery.setParameter("password", password);

		User user = (User)hquery.uniqueResult(); 
		transaction.commit();
		session.close();
		return user;
	}
	
	public void updateUser(String firstName, String lastName, String password){
		
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		User user = new User(firstName,lastName,password);
		session.update(user);
		transaction.commit();
		session.close();
		//return user;
	}
	
	public void deleteUser(User user){
		Session session = sf.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		session.delete(user);
		transaction.commit();
		session.close();
	}

}
