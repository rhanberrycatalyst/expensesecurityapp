package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.security.Principal;
import org.junit.Before;
import org.junit.Test;
import com.catalyst.springboot.services.EndUserService;

public class SecurityWebServiceTest {
	private EndUserService mockendUserService;
	private SecurityWebService securityWebService;
	private Principal mockPrincipal;

	/**
	 * set up the stage
	 */

	@Before
	public void setup() {
		mockendUserService = mock(EndUserService.class);
		mockPrincipal = mock(Principal.class);
		securityWebService = new SecurityWebService();
		securityWebService.setEndUserService(mockendUserService);

	}

	/**
	 * test getting EndUser
	 */
	@Test
	public void currentUserTest() {
		securityWebService.currentUser(mockPrincipal);
		verify(mockendUserService, times(1)).getUserByUsername((mockPrincipal.getName()));

	}
}
