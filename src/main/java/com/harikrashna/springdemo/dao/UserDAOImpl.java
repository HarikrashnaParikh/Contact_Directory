package com.harikrashna.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.harikrashna.springdemo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<User> getUsers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query................Sort by name
		Query<User> theQuery = currentSession.createQuery("from User order by name",User.class);
		
		
		
		//execute query and get result list
		List<User> user = theQuery.getResultList();
		
		for(User u : user) {
			System.out.println("User" + u);
		}
		
		//return the result
		return user;
	}


	@Override
	public void saveUser(User theUser) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Dao : "+ "Sav user request is gentrated we have got user = "+theUser);
		//save the user...... finally..lol....
		//for decision user data to be save or update 
		
		currentSession.saveOrUpdate(theUser);
		
		
	}


	@Override
	public User getUser(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class,theId);
		
		return theUser;
		
	}


	@Override
	public void deleteUser(int theId) {
		
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//delete object with primary key
		Query<?> theQuery = currentSession.createQuery("delete from User where id=:userId");
		
		theQuery.setParameter("userId", theId);
		
		//
		
		theQuery.executeUpdate();
		
	}


	@Override
	public List<User> searchUsers(String theSearchName) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery ;
		
		//Only search by name if theSearchName is not Empty
		if(theSearchName != null && theSearchName.trim().length()>0)
		{
			//Search for name ....case insensitive
			theQuery = currentSession.createQuery("from User where name like :theName",User.class);
				
		}
		else {
			//theSearchName is empty ....so just get all Users
			theQuery = currentSession.createQuery("from User order by name",User.class);
			
			//execute query anfd get full result list
			List users = theQuery.getResultList();
			
			return users;
			
		}
		return null;
	}

}





















