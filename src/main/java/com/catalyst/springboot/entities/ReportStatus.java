package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ReportStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportStatusId;
	@NotNull
	private String reportStatus;
	
	public Integer getReportStatusId() {
		return reportStatusId;
	}
	public void setReportStatusId(Integer reportStatusId) {
		this.reportStatusId = reportStatusId;
	}
	
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	
	
}
