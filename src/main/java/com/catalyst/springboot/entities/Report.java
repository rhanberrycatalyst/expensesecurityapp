package com.catalyst.springboot.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * An object representing individual reports of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;
	@NotNull
	private String name;
	private String note;

	@ManyToOne
	@JoinColumn(name="userid")
	private EndUser endUser;
	
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="statusid")
	private ReportStatus reportStatus;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<LineItem> lineItems;
	
	/**
	 * Generic getter for LineItems
	 * @return Collection<LineItem>
	 */
	public Collection<LineItem> getLineItems() {
		return lineItems;
	}
	/**
	 * Generic setter for userId
	 * @param userId
	 */
	public void setLineItems(Collection<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	/**
	 * Generic getter for endUser
	 * @return EndUser
	 */
	public EndUser getEndUser() {
		return endUser;
	}
	/**
	 * Generic setter for EndUser
	 * @param endUser
	 */
	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}
	/**
	 * Generic getter for reportId
	 * @return reportId
	 */
	public Integer getReportId() {
		return reportId;
	}
	/**
	 * Generic setter for reportId
	 * @param reportId
	 */
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	/**
	 * Generic getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Generic setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Generic getter for project
	 * @return Project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * Generic setter for project
	 * @param project
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * Generic getter for reportStatus
	 * @return ReportStatus
	 */
	public ReportStatus getReportStatus() {
		return reportStatus;
	}
	/**
	 * Generic setter for reportStatus
	 * @param status
	 */
	public void setReportStatus(ReportStatus status) {
		this.reportStatus = status;
	}
	/**
	 * Generic getter for note
	 * @return note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * Generic setter for note
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
