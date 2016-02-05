package com.catalyst.springboot.webservices;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.ReportService;
import com.catalyst.springboot.services.impl.ReportServiceImpl;

/**
 * The class <code>ReportWebServiceTest</code> contains tests for the class <code>{@link ReportWebService}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:55 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class ReportWebServiceTest {
	/**
	 * Run the void addreport(Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testAddreport_1()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		Report report = new Report();

		fixture.addreport(report);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.add(ReportServiceImpl.java:48)
		//       at com.catalyst.springboot.webservices.ReportWebService.addreport(ReportWebService.java:41)
	}

	/**
	 * Run the Report getReportByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetReportByID_1()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		Integer id = new Integer(1);

		Report result = fixture.getReportByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getByReportId(ReportServiceImpl.java:71)
		//       at com.catalyst.springboot.webservices.ReportWebService.getReportByID(ReportWebService.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the Report getReportByID(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetReportByID_2()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		Integer id = new Integer(1);

		Report result = fixture.getReportByID(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getByReportId(ReportServiceImpl.java:71)
		//       at com.catalyst.springboot.webservices.ReportWebService.getReportByID(ReportWebService.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the List<Report> getReports(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testGetReports_1()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		Integer userId = new Integer(1);

		List<Report> result = fixture.getReports(userId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.getReportsByUserId(ReportServiceImpl.java:38)
		//       at com.catalyst.springboot.webservices.ReportWebService.getReports(ReportWebService.java:51)
		assertNotNull(result);
	}

	/**
	 * Run the void setreportService(ReportService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testSetreportService_1()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		ReportService reportService = new ReportServiceImpl();

		fixture.setreportService(reportService);

		// add additional test code here
	}

	/**
	 * Run the void updatereport(Integer,Report) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:55 AM
	 */
	@Test
	public void testUpdatereport_1()
		throws Exception {
		ReportWebService fixture = new ReportWebService();
		fixture.setreportService(new ReportServiceImpl());
		Integer id = new Integer(1);
		Report report = new Report();

		fixture.updatereport(id, report);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.catalyst.springboot.services.impl.ReportServiceImpl.update(ReportServiceImpl.java:57)
		//       at com.catalyst.springboot.webservices.ReportWebService.updatereport(ReportWebService.java:71)
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
		new org.junit.runner.JUnitCore().run(ReportWebServiceTest.class);
	}
}