package com.catalyst.springboot.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * The class below creates @Entity in database with:
 * 		Auto-generated projectId
 * 		Unique name
 * 		JoinColumn for Technical Lead
 * Entity also connects to, and sets, JoinTable projectdevs for tracking developers on project.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	@NotNull
	@Column(unique=true)
	private String name;
	
	@ManyToOne(targetEntity = EndUser.class, cascade=CascadeType.ALL)
	@JoinColumn(name="techid")
	private EndUser techId;
	
	@ManyToMany
	@JoinTable(
			name = "projectdevs",
			joinColumns = @JoinColumn(name = "projects_projectid"),
			inverseJoinColumns = @JoinColumn(name = "enduser_userid")
			)
	private Collection<EndUser> endUsers;
	
	
	public Collection<EndUser> getEndUsers() {
		return endUsers;
	}

	public void setEndUsers(Collection<EndUser> endUsers) {
		this.endUsers = endUsers;
	}

	public EndUser getTechId() {
		return techId;
	}

	public void setTechId(EndUser techId) {
		this.techId = techId;
	}
	

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
