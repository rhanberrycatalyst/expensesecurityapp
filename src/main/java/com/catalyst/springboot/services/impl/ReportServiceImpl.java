package com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.InvalidInputException;
import com.catalyst.springboot.services.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;

	public void setreportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public List<Report> getReports() {

		List<Report> reports = reportDao.getAllReports();
		return reports;
	}

	@Override
	public void add(Report report) {
		System.out.println("In Impl");
		reportDao.add(report);
	}

	@Override
	public void update(Report report) {
		reportDao.update(report);
	}

	@Override
	public Report getByReportId(Integer reportId) throws InvalidInputException {
		if (reportId == null || reportId < 0) {
			throw new InvalidInputException("reportId.NullOrNegative");
		}
		return reportDao.getByReportId(reportId);
	}

	@Override
	public Report getReportByReportname(String reportname) {
		return reportDao.getReportByReportname(reportname);

	}
}
