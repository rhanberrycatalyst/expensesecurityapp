package com.catalyst.springboot.webservices;

import java.security.Principal;
import org.apache.catalina.connector.CoyotePrincipal;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
import com.catalyst.springboot.services.impl.EndUserServiceImpl;

/**
 * The class <code>SecurityWebServiceTest</code> contains tests for the class <code>{@link SecurityWebService}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class SecurityWebServiceTest {
	/**
	 * Run the EndUser currentUser(Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testCurrentUser_1()
		throws Exception {
		SecurityWebService fixture = new SecurityWebService();
		fixture.setEmployeeService(new EndUserServiceImpl());
		Principal principal = new CoyotePrincipal("");

		EndUser result = fixture.currentUser(principal);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getUserByUsername(EndUserServiceImpl.java:113)
		//       at com.catalyst.springboot.webservices.SecurityWebService.currentUser(SecurityWebService.java:32)
		assertNotNull(result);
	}

	/**
	 * Run the void setEmployeeService(EndUserService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetEmployeeService_1()
		throws Exception {
		SecurityWebService fixture = new SecurityWebService();
		fixture.setEmployeeService(new EndUserServiceImpl());
		EndUserService endUserService = new EndUserServiceImpl();

		fixture.setEmployeeService(endUserService);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(SecurityWebServiceTest.class);
	}
}