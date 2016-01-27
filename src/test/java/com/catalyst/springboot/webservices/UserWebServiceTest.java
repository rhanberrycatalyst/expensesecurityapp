package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.services.UserService;

public class UserWebServiceTest {
	private UserService mockuserService;
	private UserWebService userWebService;

	@Before
	public void createuserWebService() throws Exception {
		mockuserService = mock(UserService.class);
		userWebService = new UserWebService();
		userWebService.setuserService(mockuserService);
	}

	@Test
	public void testAdduser() throws Exception {
		userWebService.adduser(null);
		verify(mockuserService, times(1)).add(null);
	}

	@Test
	public void testGetusers() throws Exception {

		userWebService.getusers(null);
		verify(mockuserService, times(1)).getUsers(null);
	}

	@Test
	public void testGetuserByID() throws Exception {
		userWebService.getuserByID(null);
		verify(mockuserService, times(1)).getByUserId(null);
	}

	@Test
	public void testUpdateuser() throws Exception {
		userWebService.updateuser(null,null);
		verify(mockuserService, times(1)).update(null);
	}

	@Test
	public void testRemoveuser() throws Exception {
		userWebService.removeuser(null);
		verify(mockuserService, times(1)).delete(null);
	}

}
