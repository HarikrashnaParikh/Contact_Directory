package com.harikrashna.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harikrashna.springdemo.entity.Mobile;

@Repository
public class MobileDAOImpl implements MobileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Mobile> getMobiles() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query................Sort by name
		Query<Mobile> theQuery = currentSession.createQuery("from mobile", Mobile.class);

		// execute query and get result list
		List<Mobile> mobile = theQuery.getResultList();

		// return the result
		return mobile;
	}

	@Override
	public void saveMobile(Mobile theMobile) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the user...... finally..lol....
		// for decision user data to be save or update
		currentSession.saveOrUpdate(theMobile);
	}

	@Override
	public Mobile getMobile(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Mobile theMobile = currentSession.get(Mobile.class, theId);

		return theMobile;

	}

	@Override
	public void deleteMobile(int theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//delete object with primary key
		Query<?> theQuery = currentSession.createQuery("delete from Mobile where id=:mobileId");
		
		theQuery.setParameter("mobileId", theId);
		
		//
		
		theQuery.executeUpdate();
		

	}

//	@Override
//	public List<Mobile> searchUsers(String theSearchName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
