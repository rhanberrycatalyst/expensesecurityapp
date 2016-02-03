package com.catalyst.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SpringRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@NotNull
	private String role;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getSpringRole() {
		return role;
	}
	public void setSpringRole(String springRole) {
		this.role = springRole;
	}
	
}
