package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;
	private String name;

	@ManyToOne
	@JoinColumn(name="userid")
	private EndUser endUser;
	
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="statusid")
	private Status status;
	
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}