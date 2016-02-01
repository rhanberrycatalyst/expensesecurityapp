package com.catalyst.springboot.services.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.InvalidInputException;

public class EndUserServiceImplTest {

	private EndUserServiceImpl target;
	private EndUserDao mockuserDao;
	
	@Before
	public void setup(){
		target = new EndUserServiceImpl();
		mockuserDao = mock(EndUserDao.class);
		target.setuserDao(mockuserDao);
	}

	@Test
	public void testAdduser(){
		target.add(null);
		verify(mockuserDao, times(1)).add(null);
	}
	
	@Test
	public void testUpdateuser(){
		target.update(null);
		verify(mockuserDao, times(1)).update(null);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByuserIdZero() throws InvalidInputException{
		target.getByUserId(-1);
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
