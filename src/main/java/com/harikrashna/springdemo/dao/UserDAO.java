package com.harikrashna.springdemo.dao;

import java.util.List;

import com.harikrashna.springdemo.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public List<User> searchUsers(String theSearchName);

}
