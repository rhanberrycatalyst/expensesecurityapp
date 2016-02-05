package com.catalyst.springboot.daos.impl;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.Report;

/**
 * The class <code>ReportDaoImplTest</code> contains tests for the class <code>{@link ReportDaoImpl}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:52 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ReportDaoImplTest {
	/**
	 * Run the ReportDaoImpl() constructor test.
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testReportDaoImpl_1()
		throws Exception {
		ReportDaoImpl result = new ReportDaoImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void add(Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Report report = new Report();

		fixture.add(report);

		// add additional test code here
	}

	/**
	 * Run the List<Report> getAllReportsByUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetAllReportsByUserId_1()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Integer userId = new Integer(1);

		List<Report> result = fixture.getAllReportsByUserId(userId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByReportId_1()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Integer reportId = new Integer(1);

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(null, result.getProject());
		assertEquals(null, result.getEndUser());
		assertEquals(null, result.getNote());
		assertEquals(new Integer(1), result.getReportId());
		assertEquals(null, result.getLineItems());
		assertEquals(null, result.getReportStatus());
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByReportId_2()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Integer reportId = new Integer(1);

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(null, result.getProject());
		assertEquals(null, result.getEndUser());
		assertEquals(null, result.getNote());
		assertEquals(new Integer(1), result.getReportId());
		assertEquals(null, result.getLineItems());
		assertEquals(null, result.getReportStatus());
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetByReportId_3()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Integer reportId = new Integer(1);

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(null, result.getProject());
		assertEquals(null, result.getEndUser());
		assertEquals(null, result.getNote());
		assertEquals(new Integer(1), result.getReportId());
		assertEquals(null, result.getLineItems());
		assertEquals(null, result.getReportStatus());
	}

	/**
	 * Run the Report getReportByReportname(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testGetReportByReportname_1()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		String reportName = "";

		Report result = fixture.getReportByReportname(reportName);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void update(Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		ReportDaoImpl fixture = new ReportDaoImpl();
		fixture.add(new Report());
		Report report = new Report();

		fixture.update(report);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(Unknown Source)
		//       at java.util.ArrayList.set(Unknown Source)
		//       at com.catalyst.springboot.daos.impl.ReportDaoImpl.update(ReportDaoImpl.java:39)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:52 AM
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
	 * @generatedBy CodePro at 2/5/16 11:52 AM
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
	 * @generatedBy CodePro at 2/5/16 11:52 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ReportDaoImplTest.class);
	}
}