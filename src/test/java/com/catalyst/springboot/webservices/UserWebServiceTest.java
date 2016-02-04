package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.services.EndUserService;

public class UserWebServiceTest {
	private EndUserService mockuserService;
	private EndUserWebService userWebService;

	/*@Before
	public void createuserWebService() throws Exception {
		mockuserService = mock(EndUserService.class);
		userWebService = new EndUserWebService();
		userWebService.setuserService(mockuserService);
	}*/

	@Test
	public void testAdduser() throws Exception {
		userWebService.adduser(null);
		verify(mockuserService, times(1)).add(null);
	}

	/*@Test
	public void testGetusers() throws Exception {

		userWebService.getUsers(null);
		verify(mockuserService, times(1)).getUsers(null);
	}*/

	@Test
	public void testGetuserByID() throws Exception {
		userWebService.getUserByID(null);
		verify(mockuserService, times(1)).getByUserId(null);
	}

	@Test
	public void testUpdateuser() throws Exception {
		userWebService.updateuser(null,null);
		verify(mockuserService, times(1)).update(null);
	}

}
