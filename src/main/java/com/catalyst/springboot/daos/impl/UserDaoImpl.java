package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.UserDao;
import com.catalyst.springboot.entities.User;


public class UserDaoImpl implements UserDao {

	private List<User> users = new ArrayList<>();
	private Integer nextId = 1;
	
	@Override
	public void add(User user) {
		user.setUserId(nextId);
		nextId++;
		users.add(user);
		
	}
	
	@Override
	public void update(User user) {
		Integer index = users.indexOf(user);
		users.set(index, user);
	}
	
	
	@Override
	public List<User> getAllUsers() { 
		return users;
	}
	
	@Override
	public User getByUserId(Integer userId) {
		for(User e : users){
			if(e.getUserId().equals(userId)){
				return e;
			}
		}
		return null;
	}

	@Override
	public void delete(Integer userId) {
		User user = new User();
		user.setUserId(userId);
		 
		users.remove(user);
		
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
