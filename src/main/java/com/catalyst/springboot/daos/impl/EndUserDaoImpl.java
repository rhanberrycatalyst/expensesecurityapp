package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;

/**
 * The following Hibernate commands complete the CRUD functionality of the EndUserDao
 * by connecting Java to the database.
 * @author ldahlberg
 * @author gwalpole
 */
public class EndUserDaoImpl implements EndUserDao {

	private List<EndUser> users = new ArrayList<>();
	private Integer nextId = 1;
	
	/**
	 * Method calls EndUserDao function add and sends
	 * @param user to EndUserDaoHibernate
	 */
	@Override
	public void add(EndUser user) {
		user.setUserId(nextId);
		nextId++;
		users.add(user);
		
	}
	
	/**
	 * Method calls EndUserDao function update and sends
	 * @param user to EndUserDaoHibernate
	 */
	@Override
	public void update(EndUser user) {
		Integer index = users.indexOf(user);
		users.set(index, user);
	}
	
	/**
	 * Method returns list of all EndUsers
	 * @return allEndUsers
	 */
	@Override
	public List<EndUser> getAllEndUsers() { 
		return users;
	}
	
	/**
	 * Method returns single EndUser with 
	 * @param userId
	 * @return EndUser
	 */
	@Override
	public EndUser getByEndUserId(Integer userId) {
		for(EndUser e : users){
			if(e.getUserId().equals(userId)){
				return e;
			}
		}
		return null;
	}
	/**
	 * Method is currently stubbed out as unnecessary but will
	 * @return EndUser with
	 * @param userName
	 */
	@Override
	public EndUser getEndUserByEndUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
