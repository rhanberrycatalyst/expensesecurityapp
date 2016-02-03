package com.catalyst.springboot.services;

import java.util.List;

import com.catalyst.springboot.entities.Report;

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
	 * 
	 * @param isActive
	 *            - optional parameter. If supplied, will only retrieve
	 *            reports with matching values. If null, all reports are
	 *            returned.
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

}
