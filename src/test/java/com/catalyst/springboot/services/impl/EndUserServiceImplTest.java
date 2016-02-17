package com.catalyst.springboot.services.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.InvalidInputException;

public class EndUserServiceImplTest {

	private EndUserServiceImpl target;
	private EndUserDao mockuserDao;
	private EndUser mockEndUser;
	private BCryptPasswordEncoder mockEncoder;
	
	
	@Before
	public void setup(){
		target = new EndUserServiceImpl();
		mockuserDao = mock(EndUserDao.class);
		mockEndUser = mock(EndUser.class);
		target.setuserDao(mockuserDao);
		mockEncoder = mock(BCryptPasswordEncoder.class);
		target.setEncoder(mockEncoder);
	}

	@Test
	public void testAdduser(){
		
		when(mockEncoder.encode("password")).thenReturn("password");
		doNothing().when(mockEndUser).setPassword("password");
		target.add(mockEndUser);
		verify(mockuserDao, times(1)).add(mockEndUser);
	}

	@Test
	public void testGetUsers() {
		List<EndUser> expected = new ArrayList<>();
		when(mockuserDao.getAllEndUsers()).thenReturn(expected);
		target.getUsers();
		verify(mockuserDao, times(1)).getAllEndUsers();
	}
/*	
	@Test
	public void testUpdateUser(){
		EndUser mockEndUser2 = mock(EndUser.class);
		when(mockProject.getTechId()).thenReturn(mockEndUser2);
		when(mockEndUser2.getUserId()).thenReturn(1);
		
		
		when(mockEncoder.encode("password")).thenReturn("password");
		doNothing().when(mockEndUser).setPassword("password");
		target.update(null);
		verify(mockuserDao, times(1)).update(null);
	}*/
	
	@Test(expected=InvalidInputException.class)
	public void testGetByuserIdZero() throws InvalidInputException{
		target.getByUserId(-1);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByUserNull() throws InvalidInputException{
		target.getByUserId(null);
	}
	
	@Test
	public void testGetByuserIdSuccess() throws InvalidInputException{
		target.getByUserId(1);
		
		verify(mockuserDao, times(1)).getByEndUserId(any());
	}
	
	/*@Test
	public void testGetusersNoFilter(){
		int expected = 2;
		List<User> users = userList();
		when(mockuserDao.getAllUsers()).thenReturn(users);
		List<User> actual = target.getUsers(null);
		assertEquals(expected, actual.size());
		
	}

	@Test
	public void testGetusersActive(){
		int expected = 1;
		List<User> users = userList();
		when(mockuserDao.getAllUsers()).thenReturn(users);
		List<User> actual = target.getUsers(true);
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void testGetusersInactive(){
		int expected = 1;
		List<User> users = userList();
		when(mockuserDao.getAllUsers()).thenReturn(users);
		List<User> actual = target.getUsers(false);
		assertEquals(expected, actual.size());
	}
	
	private List<User> userList() {
		List<User> users = new ArrayList<>();
		User e = new User();
		e.setActive(true);
		users.add(e);
		e = new User();
		e.setActive(false);
		users.add(e);
		return users;
	}*/
	
	
}
