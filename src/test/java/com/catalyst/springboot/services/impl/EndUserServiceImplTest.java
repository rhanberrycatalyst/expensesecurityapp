package com.catalyst.springboot.services.impl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate;
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
	
	

	/**
	 * Run the void add(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUser user = new EndUser();
		user.setPassword("");

		fixture.add(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.add(EndUserDaoHibernate.java:41)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.add(EndUserServiceImpl.java:65)
	}

	/**
	 * Run the EndUser getByUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByUserId_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		Integer userId = new Integer(1);

		EndUser result = fixture.getByUserId(userId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getByUserId(EndUserServiceImpl.java:102)
		assertNotNull(result);
	}

	/**
	 * Run the EndUser getByUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByUserId_2()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		Integer userId = new Integer(1);

		EndUser result = fixture.getByUserId(userId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getByUserId(EndUserServiceImpl.java:102)
		assertNotNull(result);
	}

	/**
	 * Run the EndUser getByUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test(expected = com.catalyst.springboot.services.InvalidInputException.class)
	public void testGetByUserId_3()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		Integer userId = null;

		EndUser result = fixture.getByUserId(userId);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the EndUser getUserByUsername(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetUserByUsername_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		String email = "";

		EndUser result = fixture.getUserByUsername(email);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getEndUserByEndUsername(EndUserDaoHibernate.java:78)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getUserByUsername(EndUserServiceImpl.java:113)
		assertNotNull(result);
	}

	/**
	 * Run the List<EndUser> getUsers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetUsers_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());

		List<EndUser> result = fixture.getUsers();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getAllEndUsers(EndUserDaoHibernate.java:53)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getUsers(EndUserServiceImpl.java:52)
		assertNotNull(result);
	}

	/**
	 * Run the void setEncoder(BCryptPasswordEncoder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetEncoder_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		fixture.setEncoder(encoder);

		// add additional test code here
	}

	/**
	 * Run the void setuserDao(EndUserDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetuserDao_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUserDao userDao = new EndUserDaoHibernate();

		fixture.setuserDao(userDao);

		// add additional test code here
	}

	/**
	 * Run the void update(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUser user = new EndUser();
		user.setUserId(new Integer(1));
		user.setPassword("");

		fixture.update(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.update(EndUserServiceImpl.java:75)
	}

	/**
	 * Run the void update(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_2()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUser user = new EndUser();
		user.setUserId(new Integer(1));
		user.setPassword("");

		fixture.update(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.update(EndUserServiceImpl.java:75)
	}

	/**
	 * Run the void update(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_3()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUser user = new EndUser();
		user.setUserId(new Integer(1));
		user.setPassword("");

		fixture.update(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.update(EndUserServiceImpl.java:75)
	}

	/**
	 * Run the void update(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_4()
		throws Exception {
		EndUserServiceImpl fixture = new EndUserServiceImpl();
		fixture.setuserDao(new EndUserDaoHibernate());
		fixture.setEncoder(new BCryptPasswordEncoder());
		EndUser user = new EndUser();
		user.setUserId(new Integer(1));
		user.setPassword("");

		fixture.update(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.EndUserDaoHibernate.getByEndUserId(EndUserDaoHibernate.java:64)
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.update(EndUserServiceImpl.java:75)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EndUserServiceImplTest.class);
	}
}
