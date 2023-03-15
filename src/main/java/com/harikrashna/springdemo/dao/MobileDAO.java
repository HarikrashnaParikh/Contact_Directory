package com.harikrashna.springdemo.dao;

import java.util.List;

import com.harikrashna.springdemo.entity.Mobile;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
public interface MobileDAO {
	
	public List<Mobile> getMobiles();

	public void saveMobile(Mobile theMobile);

	public Mobile getMobile(int theId);

	public void deleteMobile(int theId);

//	public List<Mobile> searchMobiles(String theSearchName);

}
