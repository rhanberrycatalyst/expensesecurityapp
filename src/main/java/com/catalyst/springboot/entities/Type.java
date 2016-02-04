package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * An object representing individual users of the application.
 * @author ldahlberg
 * @author gwalpole
 */
@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeId;
	@NotNull
	private String type;
	
	/**
	 * Generic getter for typeId
	 * @return typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * Generic getter for type
	 * @return type
	 */
	public String getType() {
		return type;
	}
}
