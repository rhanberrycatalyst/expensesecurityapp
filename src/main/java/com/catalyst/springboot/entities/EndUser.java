package com.catalyst.springboot.entities;

<<<<<<< HEAD:src/main/java/com/catalyst/springboot/entities/EndUser.java
=======
import java.util.Set;

>>>>>>> Sprint_1:src/main/java/com/catalyst/springboot/entities/EndUser.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class EndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Boolean isAdmin;
	 
	@ManyToMany
	@JoinTable(name = "projectdevs")
	Set<Project> projects;
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(31, 17);
		builder.append(userId);
		return builder.toHashCode();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
<<<<<<< HEAD:src/main/java/com/catalyst/springboot/entities/EndUser.java
=======

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
>>>>>>> Sprint_1:src/main/java/com/catalyst/springboot/entities/EndUser.java
 
}
