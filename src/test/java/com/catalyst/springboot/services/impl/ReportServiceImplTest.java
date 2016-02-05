package com.catalyst.springboot.services.impl;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.daos.hibernate.ReportDaoHibernate;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.InvalidInputException;

/**
 * The class <code>ReportServiceImplTest</code> contains tests for the class <code>{@link ReportServiceImpl}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ReportServiceImplTest {
	/**
	 * Run the void add(Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Report report = new Report();

		fixture.add(report);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.add(ReportDaoHibernate.java:45)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.add(ReportServiceImpl.java:48)
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByReportId_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Integer reportId = new Integer(1);

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.getByReportId(ReportDaoHibernate.java:101)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getByReportId(ReportServiceImpl.java:71)
		assertNotNull(result);
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetByReportId_2()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Integer reportId = new Integer(1);

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.getByReportId(ReportDaoHibernate.java:101)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getByReportId(ReportServiceImpl.java:71)
		assertNotNull(result);
	}

	/**
	 * Run the Report getByReportId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test(expected = com.catalyst.springboot.services.InvalidInputException.class)
	public void testGetByReportId_3()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Integer reportId = null;

		Report result = fixture.getByReportId(reportId);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Report getReportByReportname(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetReportByReportname_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		String reportName = "";

		Report result = fixture.getReportByReportname(reportName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.getReportByReportname(ReportDaoHibernate.java:112)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getReportByReportname(ReportServiceImpl.java:81)
		assertNotNull(result);
	}

	/**
	 * Run the List<Report> getReportsByUserId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetReportsByUserId_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Integer userId = new Integer(1);

		List<Report> result = fixture.getReportsByUserId(userId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.getAllReportsByUserId(ReportDaoHibernate.java:90)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getReportsByUserId(ReportServiceImpl.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the void setreportDao(ReportDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetreportDao_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		ReportDao reportDao = new ReportDaoHibernate();

		fixture.setreportDao(reportDao);

		// add additional test code here
	}

	/**
	 * Run the void update(Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		ReportServiceImpl fixture = new ReportServiceImpl();
		fixture.setreportDao(new ReportDaoHibernate());
		Report report = new Report();

		fixture.update(report);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.daos.hibernate.ReportDaoHibernate.update(ReportDaoHibernate.java:123)
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.update(ReportServiceImpl.java:57)
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
		new org.junit.runner.JUnitCore().run(ReportServiceImplTest.class);
	}
}