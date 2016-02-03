package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@NotNull
	private String title;

	public Integer getRoleId() {
		return roleId;
	}

	public String getTitle() {
		return title;
	}
	
	
}
