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
 * An object representing individual project of the application.
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

	/**
	 * Generic getter for Collection<EndUser>
	 * @return Collection<EndUser>
	 */
	public Collection<EndUser> getEndUsers() {
		return endUsers;
	}

	/**
	 * Generic setter for Collection<EndUser>
	 * @param endUsers
	 */
	public void setEndUsers(Collection<EndUser> endUsers) {
		this.endUsers = endUsers;
	}

	/**
	 * Generic getter for techId
	 * @return EndUser
	 */
	public EndUser getTechId() {
		return techId;
	}

	/**
	 * Generic setter for techUser
	 * @param techId
	 */
	public void setTechId(EndUser techId) {
		this.techId = techId;
	}

	/**
	 * Generic getter for projectId
	 * @return Integer
	 */

	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * Generic setter for projectId
	 * @param projectId
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (projectId == null) {
			if (other.projectId != null) {
				return false;
			}
		} else if (!projectId.equals(other.projectId)){
			return false;
		}
		return true;
	}
}
