package com.catalyst.springboot.services.impl;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.InvalidInputException;

import static org.mockito.Mockito.*;
import com.catalyst.springboot.daos.ReportDao;

public class ReportServiceImplTest {
	private ReportServiceImpl target;
	private ReportDao mockReportDao;
    private Report dummy;
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		target = new ReportServiceImpl();
		mockReportDao=mock(ReportDao.class);
		target.setreportDao(mockReportDao);
		dummy=new Report();
	}
	/**
	 * test for the getting reports by passing his userId 
	 */
	@Test
	public void getReportsByUserIdTest(){
		target.getReportsByUserId(1);
		verify(mockReportDao).getAllReportsByUserId(1);
	}
	/**
	 * test for the add report  
	 */
	@Test
	public void  addTest(){
		target.add(null);
		verify(mockReportDao).add(null);
	}
	/**
	 * test for the update report  by passing reportId
	 */
	@Test
	public void updateTest(){
		target.update(null);
		verify(mockReportDao).update(null);
	}
	/**
	 * test for the getting report  by passing reportId
	 */
	@Test
	public void getByReportIdTest() throws InvalidInputException {
		target.getByReportId(1);
		verify(mockReportDao).getByReportId(1);
	}
	/**
	 * test for the getting report  by passing reportName
	 * @throws InvalidInputException 
	 */
	@Test
	public void getReportByReportnameTest(){
		target.getReportByReportname(null);
		verify(mockReportDao).getReportByReportname(null);
	}
	/**
	 * test for the updating reportstatus to submit  by passing reportId
	 *  
	 */
	@Test
	public void updateToSubmitTest(){
		target.updateToSubmit(null);
		verify(mockReportDao).updateToSubmit(null);
	}
	/**
	 * test for the getting submitted reports   by passing projectList
	 *  
	 */
	@Test
	public void getSubmittedReportsByProjectsTest(){
		Project[] dummyprojectList = null;
		target.getSubmittedReportsByProjects(dummyprojectList);
		verify(mockReportDao).getSubmittedReportsByProjects(dummyprojectList);
	}
}  
