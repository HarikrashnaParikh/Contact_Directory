package com.harikrashna.springdemo.service;

import java.util.List;

import com.harikrashna.springdemo.entity.Mobile;
//import com.harikrashna.springdemo.entity.User;

public interface MobileService {

	public List<Mobile> getMobiles();

	public void saveMobile(Mobile theMobile);

	public Mobile getMobile(int theId);

	public void deleteMobile(int theId);

//	public List<Mobile> searchUsers(String theSearchName);

}
