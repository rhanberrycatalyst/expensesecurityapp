package com.catalyst.springboot.webservices;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.ReportService;
import com.catalyst.springboot.services.InvalidInputException;

@RestController
public class ReportWebService {
	
	@Autowired
	private ReportService reportService;
	
	public void setreportService(ReportService reportService) {
		this.reportService = reportService;
	}

	
	
	@RequestMapping(value="/reports", method=RequestMethod.POST)
	public void addreport(@RequestBody Report report){
		reportService.add(report);
	} 
		
		
	@RequestMapping(value="/reports/{userid}", method = RequestMethod.GET)
	public List<Report> getReports(@PathVariable Integer userId){
		return reportService.getReportsByUserId(userId);
	}	
	
	@RequestMapping(value="/reportlist/{id}", method=RequestMethod.GET)
	public Report getReportByID(@PathVariable Integer id) throws InvalidInputException{ 
		Report report  = reportService.getByReportId(id);
		report.setEndUser(null);
		report.setProject(null);
		return report;
	}

	@RequestMapping(value="/reports/{id}", method = RequestMethod.PUT)
	public void updatereport(@PathVariable Integer id, @RequestBody Report report){
		reportService.update(report);
	}
}
