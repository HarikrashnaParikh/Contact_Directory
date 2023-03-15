package com.harikrashna.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.harikrashna.springdemo.dao.UserDAO;
import com.harikrashna.springdemo.entity.User;



@Service
public class UserServiceImpl implements UserService {

	//need to inject User DAO
	@Autowired
	private UserDAO userDAO;
	
	
	
	@Override
	@Transactional
	public List<User> getUsers()
	{
		
		return userDAO.getUsers();
	}



	@Override
	@Transactional
	public void saveUser(User theUser) {
		System.out.println("Servicre : "+ "Sav user request is gentrated we have got user = "+theUser);
		userDAO.saveUser(theUser);
		
	}



	@Override
	@Transactional
	public User getUser(int theId) {
		
		return userDAO.getUser(theId);
	}



	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
		
	}



	@Override
	@Transactional
	public List<User> searchUsers(String theSearchName) {
		 
		return userDAO.searchUsers(theSearchName);
	}
	
	
	

}
