package com.catalyst.springboot.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * An object representing individual users of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class EndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private Boolean isActive;
	 
	@JoinTable(name = "user_project_roles")
	@MapKeyJoinColumn(name = "projects")
	@ElementCollection
	private Map<Project,Role> roleByproject = new HashMap<>();
	
	@ManyToMany(mappedBy="endUsers")
	private Collection<Project> project;
	
	@ManyToOne
	@JoinColumn(name="springroleid")
	private SpringRole springrole;
	
	/**
	 * Generic setter for userId
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * Generic getter for userId
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * Generic getter for firstname
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Generic setter for firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Generic getter for lastname
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Generic setter for lastname
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Generic setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Generic getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Generic getter for email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Generic setter for email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Generic getter for isActive
	 * @return
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * Generic setter for isActive
	 * @param isActive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * Auto-generated hashCode function 
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(userId);
		return builder.toHashCode();
	}

	/**
	 * auto-generated equals function
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EndUser)){
			return false;
		}
		EndUser user = (EndUser) obj;
 
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.userId, user.userId);
		return builder.isEquals();
		
	}

}
