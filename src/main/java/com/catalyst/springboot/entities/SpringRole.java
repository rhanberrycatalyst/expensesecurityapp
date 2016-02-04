package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * An object representing individual spring roles of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class SpringRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@NotNull
	private String role;
	
	/**
	 * Generic getter for roleId
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * Generic setter for roleId
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * Generic getter for Spring Role
	 * @return role
	 */
	public String getSpringRole() {
		return role;
	}
	/**
	 * Generic setter for Spring Role
	 * @param springRole
	 */
	public void setSpringRole(String springRole) {
		this.role = springRole;
	}
	
}
