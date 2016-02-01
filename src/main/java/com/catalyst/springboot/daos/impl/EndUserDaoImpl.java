package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;


public class EndUserDaoImpl implements EndUserDao {

	private List<EndUser> users = new ArrayList<>();
	private Integer nextId = 1;
	
	@Override
	public void add(EndUser user) {
		user.setUserId(nextId);
		nextId++;
		users.add(user);
		
	}
	
	@Override
	public void update(EndUser user) {
		Integer index = users.indexOf(user);
		users.set(index, user);
	}
	
	
	@Override
	public List<EndUser> getAllEndUsers() { 
		return users;
	}
	
	@Override
	public EndUser getByEndUserId(Integer userId) {
		for(EndUser e : users){
			if(e.getUserId().equals(userId)){
				return e;
			}
		}
		return null;
	}

	@Override
	public EndUser getEndUserByEndUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
