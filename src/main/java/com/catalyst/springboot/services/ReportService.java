package com.catalyst.springboot.services;

import java.util.List;

import com.catalyst.springboot.entities.Report;

/**
 * The methods declared in this interface are to provide basic WebService functionality 
 * @author ldahlberg
 * @author gwalpole
 */
public interface ReportService {

	/**
	 * Add a new report to the application.
	 * 
	 * @param report
	 */
	void add(Report report);

	/**
	 * Update the information in an existing report. The reportId is used to
	 * find the unique report's information.
	 * 
	 * @param report
	 */
	void update(Report report);

	/**
	 * Retrieve all reports from the application.
	 * @return
	 */
	List<Report> getReportsByUserId(Integer userId);

	/**
	 * Retrieve union table of report and the reports associated line items.
	 * 
	 * @param reportId
	 * @return
	 * @throws InvalidInputException
	 *             - the value of reportId provided should not be null or less
	 *             than 0
	 */
	Report getByReportId(Integer reportId) throws InvalidInputException;

	/**
	 * Retrieve a single report's information if that report's reportname
	 * matches the supplied reportName.
	 * 
	 * @param reportName
	 * @return
	 */
	Report getReportByReportname(String reportName);
	
	/**
	 * Update the status in an existing report to submit. The reportId is used to
	 * find the unique report's information.
	 * 
	 * @param id
	 */
	

	void updateToSubmit(Integer id);

	

	



}
