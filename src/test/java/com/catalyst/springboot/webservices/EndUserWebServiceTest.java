package com.catalyst.springboot.webservices;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
import com.catalyst.springboot.services.impl.EndUserServiceImpl;

/**
 * The class <code>EndUserWebServiceTest</code> contains tests for the class <code>{@link EndUserWebService}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class EndUserWebServiceTest {
	/**
	 * Run the void adduser(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAdduser_1()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());
		EndUser user = new EndUser();

		fixture.adduser(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.add(EndUserServiceImpl.java:63)
		//       at com.catalyst.springboot.webservices.EndUserWebService.adduser(EndUserWebService.java:41)
	}

	/**
	 * Run the EndUser getUserByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetUserByID_1()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());
		Integer id = new Integer(1);

		EndUser result = fixture.getUserByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getByUserId(EndUserServiceImpl.java:102)
		//       at com.catalyst.springboot.webservices.EndUserWebService.getUserByID(EndUserWebService.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the EndUser getUserByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetUserByID_2()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());
		Integer id = new Integer(1);

		EndUser result = fixture.getUserByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getByUserId(EndUserServiceImpl.java:102)
		//       at com.catalyst.springboot.webservices.EndUserWebService.getUserByID(EndUserWebService.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the List<EndUser> getusers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetusers_1()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());

		List<EndUser> result = fixture.getusers();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.getUsers(EndUserServiceImpl.java:52)
		//       at com.catalyst.springboot.webservices.EndUserWebService.getusers(EndUserWebService.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the void setUserService(EndUserService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetUserService_1()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());
		EndUserService userService = new EndUserServiceImpl();

		fixture.setUserService(userService);

		// add additional test code here
	}

	/**
	 * Run the void updateuser(Integer,EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdateuser_1()
		throws Exception {
		EndUserWebService fixture = new EndUserWebService();
		fixture.setUserService(new EndUserServiceImpl());
		Integer id = new Integer(1);
		EndUser user = new EndUser();

		fixture.updateuser(id, user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.EndUserServiceImpl.update(EndUserServiceImpl.java:75)
		//       at com.catalyst.springboot.webservices.EndUserWebService.updateuser(EndUserWebService.java:70)
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
		new org.junit.runner.JUnitCore().run(EndUserWebServiceTest.class);
	}
}