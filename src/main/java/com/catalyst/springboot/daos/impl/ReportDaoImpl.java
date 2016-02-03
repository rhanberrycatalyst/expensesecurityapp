package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.Report;

/**
 * The following Hibernate commands complete the CRUD functionality of the ReportDao
 * by connecting Java to the database.
 * @author ldahlberg
 * @author gwalpole
 */
public class ReportDaoImpl implements ReportDao{
	
	private List<Report> reports = new ArrayList<>();
	private Integer nextId = 1;
	
	/**
	 * Method calls ReportDao function add and sends 
	 * @param to ReportDaoHibernate
	 */
	@Override
	public void add(Report report) {
		report.setReportId(nextId);
		nextId++;
		reports.add(report);
		
	}
	
	/**
	 * Method calls ReportDao function update and sends 
	 * @param report to ReportDaoHibernate
	 */
	@Override
	public void update(Report report) {
		Integer index = reports.indexOf(report);
		reports.set(index, report);
	}
	
	/**
	 * Method returns
	 * @return List<Report> for user with 
	 * @param userId.
	 */
	@Override
	public List<Report> getAllReportsByUserId(Integer userId) { 
		return reports;
	}
	
	/**
	 * Method returns
	 * @return Report with 
	 * @param reportId.
	 */
	@Override
	public Report getByReportId(Integer reportId) {
		for(Report r : reports){
			if(r.getReportId().equals(reportId)){
				return r;
			}
		}
		return null;
	}

	/**
	 * Method currently stubbed but will
	 * @return Report with 
	 * @param reportName.
	 */
	@Override
	public Report getReportByReportname(String reportName) {
		// TODO Auto-generated method stub
		return null;
	}
}
