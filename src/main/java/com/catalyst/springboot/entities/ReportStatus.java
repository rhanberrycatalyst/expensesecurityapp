package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * An object representing report statuses of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class ReportStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportStatusId;
	@NotNull
	private String reportStatus;
	
	/**
	 * Generic getter for reportStatusId
	 * @return Integer
	 */
	public Integer getReportStatusId() {
		return reportStatusId;
	}
	/**
	 * Generic setter for reportStatusId
	 * @param reportStatusId
	 */
	public void setReportStatusId(Integer reportStatusId) {
		this.reportStatusId = reportStatusId;
	}
	/**
	 * Generic getter for ReportStatus
	 * @return String
	 */
	public String getReportStatus() {
		return reportStatus;
	}
	/**
	 * Generic setter for ReportStatus
	 * @param reportStatus
	 */
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	
	
}
