package com.harikrashna.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harikrashna.springdemo.dao.MobileDAO;
//import com.harikrashna.springdemo.dao.UserDAO;
import com.harikrashna.springdemo.entity.Mobile;
//import com.harikrashna.springdemo.entity.User;

@Service
public class MobileServiceImpl implements MobileService {
	

	//need to inject Mobile DAO
	@Autowired
	private MobileDAO mobileDAO;
	
	
	
	@Override
	@Transactional
	public List<Mobile> getMobiles()
	{
		
		return mobileDAO.getMobiles();
	}



	@Override
	@Transactional
	public void saveMobile(Mobile theMobile) {
		
		mobileDAO.saveMobile(theMobile);
		
	}



	@Override
	@Transactional
	public Mobile getMobile(int theId) {
		
		return mobileDAO.getMobile(theId);
	}



	@Override
	@Transactional
	public void deleteMobile(int theId) {
		mobileDAO.deleteMobile(theId);
		
	}

}
