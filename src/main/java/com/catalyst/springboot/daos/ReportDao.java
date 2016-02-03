package com.catalyst.springboot.daos;

import java.util.List;

import com.catalyst.springboot.entities.Report;
/**
 * The methods declared in this interface are to provide basic CRUD functionality related to report objects.
 * @author Ernest
 *
 */
public interface ReportDao {
		/**
		 * Adds information about an report to storage.
		 * @param report
		 */
		void add(Report report);

		/**
		 * Updates the information about an report already in storage.
		 * @param report
		 */
		void update(Report report);
		
		/**
		 * Retrieves all reports currently in storage.
		 * @return
		 */
		List<Report> getAllReportsByUserId(Integer userId);
		
		/**
		 * Retrieve information about a single report from storage with a matching reportId
		 * @param reportId
		 * @return
		 */
		Report getByReportId(Integer reportId);

		/**
		 * Retrieves an report with a matching reportname.
		 * 
		 * @param reportName
		 * @return
		 */
		Report getReportByReportname(String reportName);
}
