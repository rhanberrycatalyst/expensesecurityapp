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

import org.apache.commons.lang3.StringUtils;
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
	
	@Test
	public void testUpdateUserMatch(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("test");
		
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
	@Test
	public void testUpdateUserEmpty(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("");
		
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
	@Test
	public void testUpdateUserNewPassword(){
		EndUser paramUser = mock(EndUser.class);
		when(paramUser.getUserId()).thenReturn(1);
		when(mockuserDao.getByEndUserId(1)).thenReturn(mockEndUser);
		when(mockEndUser.getPassword()).thenReturn("test");
		when(paramUser.getPassword()).thenReturn("test2");
		
		when(mockEncoder.encode("test2")).thenReturn("test2");
		doNothing().when(paramUser).setPassword("test");
		target.update(paramUser);
		verify(mockuserDao, times(1)).update(paramUser);
	}
	
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
	
	@Test
	public void testGetUserByUserName(){
		target.getUserByUsername("Luke");
		
		verify(mockuserDao, times(1)).getEndUserByEndUsername(any());
	}
	
}
