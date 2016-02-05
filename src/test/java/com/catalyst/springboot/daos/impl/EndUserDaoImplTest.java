package com.catalyst.springboot.daos.impl;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.EndUser;

/**
 * The class <code>EndUserDaoImplTest</code> contains tests for the class <code>{@link EndUserDaoImpl}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:48 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class EndUserDaoImplTest {
	/**
	 * Run the EndUserDaoImpl() constructor test.
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testEndUserDaoImpl_1()
		throws Exception {
		EndUserDaoImpl result = new EndUserDaoImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void add(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		EndUser user = new EndUser();

		fixture.add(user);

		// add additional test code here
	}

	/**
	 * Run the List<EndUser> getAllEndUsers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testGetAllEndUsers_1()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());

		List<EndUser> result = fixture.getAllEndUsers();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the EndUser getByEndUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testGetByEndUserId_1()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		Integer userId = new Integer(1);

		EndUser result = fixture.getByEndUserId(userId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getSpringrole());
		assertEquals(null, result.getFirstname());
		assertEquals(null, result.getLastname());
		assertEquals(null, result.getIsActive());
		assertEquals(new Integer(1), result.getUserId());
		assertEquals(null, result.getEmail());
	}

	/**
	 * Run the EndUser getByEndUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testGetByEndUserId_2()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		Integer userId = new Integer(1);

		EndUser result = fixture.getByEndUserId(userId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getSpringrole());
		assertEquals(null, result.getFirstname());
		assertEquals(null, result.getLastname());
		assertEquals(null, result.getIsActive());
		assertEquals(new Integer(1), result.getUserId());
		assertEquals(null, result.getEmail());
	}

	/**
	 * Run the EndUser getByEndUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testGetByEndUserId_3()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		Integer userId = new Integer(1);

		EndUser result = fixture.getByEndUserId(userId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getSpringrole());
		assertEquals(null, result.getFirstname());
		assertEquals(null, result.getLastname());
		assertEquals(null, result.getIsActive());
		assertEquals(new Integer(1), result.getUserId());
		assertEquals(null, result.getEmail());
	}

	/**
	 * Run the EndUser getEndUserByEndUsername(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testGetEndUserByEndUsername_1()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		String email = "";

		EndUser result = fixture.getEndUserByEndUsername(email);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void update(EndUser) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		EndUserDaoImpl fixture = new EndUserDaoImpl();
		fixture.add(new EndUser());
		EndUser user = new EndUser();

		fixture.update(user);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(Unknown Source)
		//       at java.util.ArrayList.set(Unknown Source)
		//       at com.catalyst.springboot.daos.impl.EndUserDaoImpl.update(EndUserDaoImpl.java:38)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:48 AM
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
	 * @generatedBy CodePro at 2/5/16 11:48 AM
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
	 * @generatedBy CodePro at 2/5/16 11:48 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EndUserDaoImplTest.class);
	}
}