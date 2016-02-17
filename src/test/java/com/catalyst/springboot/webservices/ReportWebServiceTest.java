package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.ReportService;

public class ReportWebServiceTest {
	private  ReportWebService  mockReportWebService;
	private ReportService mockReportService;
	private  Report dummy;
	
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockReportService = mock(ReportService.class);
		 mockReportWebService = new ReportWebService();
		 mockReportWebService.setreportService(mockReportService);
		 dummy = new Report();
		
	}
	/**
	 * test for getting all collectibles
	 */
	@Test
	public void addreportTest(){
			
		mockReportWebService.addreport(dummy);
		verify(mockReportService).add(dummy);
		
	}
	
	/**
	 * test for getting all reports by userid
	 */
	@Test
	public void getReportsTest(){
		mockReportWebService.getReports(2);
		verify(mockReportService).getReportsByUserId(2);
	}
	/**
	 * test for getting all reports by reportid
	 * @throws InvalidInputException 
	 */
	@Test
	public void getReportByIDTest() throws InvalidInputException{
		mockReportWebService.getReportByID(1);
		verify(mockReportService).getByReportId(1);
	}
	/**
	 * test for updating a report by passing id
	 */
	@Test
	public void updatereportTest(){
		mockReportWebService.updatereport(1, dummy);
		verify(mockReportService).update(dummy);
	}
	/**
	 * test for updating a reportstatus by passing reportid
	 */
	@Test
	public void updateReportToSubmitTest(){
		mockReportWebService.updateReportToSubmit(1);
		verify(mockReportService).updateToSubmit(1);
	}

	/**
	 * test for getting  the subitted reports belonging to any of a list of projects passed in 
	 */
	@Test
	public void  getSubmittedReportsByProjects(){
		Project[] dummyProjectList = null;
		mockReportWebService.getSubmittedReportsByProjects(dummyProjectList);
		verify(mockReportService).getSubmittedReportsByProjects(dummyProjectList);
		
	}
}
