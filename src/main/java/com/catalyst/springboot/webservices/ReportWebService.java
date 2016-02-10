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

/**
 * The web service for the Report table's Database access
 * @author ldahlberg
 * @author gwalpole
 */
@RestController
public class ReportWebService {
	
	@Autowired
	private ReportService reportService;
	
	/**
	 * Sets a reportService object
	 * @param reportService
	 */
	public void setreportService(ReportService reportService) {
		this.reportService = reportService;
	}

	/**
	 * Adds a new report to the database.
	 * @param report
	 */
	@RequestMapping(value="/reports", method=RequestMethod.POST)
	public void addreport(@RequestBody Report report){
		reportService.add(report);
	} 
		
	/**
	 * Returns a list of all Reports with
	 * @param userId
	 * @return List<Report>
	 */	
	@RequestMapping(value="/reports/{userId}", method = RequestMethod.GET)
	public List<Report> getReports(@PathVariable Integer userId){
		return reportService.getReportsByUserId(userId);
	}	
	
	/**
	 * Returns Report with
	 * @param id
	 * @return Report
	 */	
	@RequestMapping(value="/reportlist/{id}", method=RequestMethod.GET)
	public Report getReportByID(@PathVariable Integer id) throws InvalidInputException{ 
		return reportService.getByReportId(id);
	}

	/**
	 * Updates Report with
	 * @param id
	 * @return Report
	 */	
	@RequestMapping(value="/reports/{id}", method = RequestMethod.PUT)
	public void updatereport(@PathVariable Integer id, @RequestBody Report report){
		reportService.update(report);
	}
}
