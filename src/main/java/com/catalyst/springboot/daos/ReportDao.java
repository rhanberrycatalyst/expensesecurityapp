package com.catalyst.springboot.daos;

import java.util.List;

import com.catalyst.springboot.entities.Report;
/**
 * The methods declared in this interface are to provide basic CRUD functionality related to report objects.
 * @author ldahlberg
 * @author gwalpole
 *
 */
public interface ReportDao {
		/**
		 * Adds information about a report to database.
		 * @param report
		 */
		void add(Report report);

		/**
		 * Updates the information about a report already in database.
		 * @param report
		 */
		void update(Report report);
		
		/**
		 * Retrieves all reports currently in database.
		 * @return
		 */
		List<Report> getAllReportsByUserId(Integer userId);
		
		/**
		 * Retrieves report and corresponding lineItem(s) in report with reportId.
		 * 
		 * @param reportId
		 * @return
		 */
		Report getByReportId(Integer reportId);

		/**
		 * Retrieves an report with a matching reportName.
		 * 
		 * @param reportName
		 * @return
		 */
		Report getReportByReportname(String reportName);

}
