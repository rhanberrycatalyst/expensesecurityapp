package com.catalyst.springboot.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.springboot.daos.ReportDao;
import com.catalyst.springboot.entities.Report;

public class ReportDaoImpl implements ReportDao{
	
	private List<Report> reports = new ArrayList<>();
	private Integer nextId = 1;
	
	@Override
	public void add(Report report) {
		report.setReportId(nextId);
		nextId++;
		reports.add(report);
		
	}
	
	@Override
	public void update(Report report) {
		Integer index = reports.indexOf(report);
		reports.set(index, report);
	}
	
	
	@Override
	public List<Report> getAllReportsByUserId(Integer userId) { 
		return reports;
	}
	
	@Override
	public Report getByReportId(Integer reportId) {
		for(Report p : reports){
			if(p.getReportId().equals(reportId)){
				return p;
			}
		}
		return null;
	}

	@Override
	public Report getReportByReportname(String reportName) {
		// TODO Auto-generated method stub
		return null;
	}
}
