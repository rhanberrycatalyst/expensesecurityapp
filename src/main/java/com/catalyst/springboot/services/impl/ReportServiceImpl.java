package com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.ReportService;

/**
 * The methods below implements the ReportService interface
 * @author ldahlberg
 * @author gwalpole
 */
@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;

	/**
	 * Sets ReportDao
	 */
	public void setreportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	/**
	 * Method gets List<Report> with
	 * @param userId. 
	 * @return List<Report>
	 */
	@Override
	public List<Report> getReportsByUserId(Integer userId) {

		List<Report> reports = reportDao.getAllReportsByUserId(userId);
		return reports;
	}

	/**
	 * Method adds single report with
	 * @param report 
	 */
	@Override
	public void add(Report report) {
		reportDao.add(report);
	}

	/**
	 * Method updates single report with
	 * @param reportId. 
	 */
	@Override
	public void update(Report report) {
		reportDao.update(report);
	}

	/**
	 * Method gets single report with
	 * @param reportId. 
	 * @throws InvalidInputException for null
	 * @return Report
	 */
	@Override
	public Report getByReportId(Integer reportId) throws InvalidInputException {
		if (reportId == null || reportId < 0) {
			throw new InvalidInputException("reportId.NullOrNegative");
		}
		return reportDao.getByReportId(reportId);
	}

	/**
	 * Method gets single report with
	 * @param reportName. 
	 * @return Report
	 */
	@Override
	public Report getReportByReportname(String reportName) {
		return reportDao.getReportByReportname(reportName);

	}
	/**
	 * Method updates single reportstatus  to submit with
	 * @param reportId. i
	 */
	@Override
	public void updateToSubmit(Integer id) {
		
		reportDao.updateToSubmit(id);
	
	
}
}
