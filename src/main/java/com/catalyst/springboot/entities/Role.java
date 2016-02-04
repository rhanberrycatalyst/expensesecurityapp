package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * An object representing individual roles of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@NotNull
	private String title;

	/**
	 * Generic getter for roleId
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * Generic getter for title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
}
