package com.example.perfectionnement.eduLine.dto;

import com.example.perfectionnement.eduLine.enums.userRole;
import lombok.Data;

@Data
public class UserDto {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private userRole userRole;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public userRole getUserRole() {
		return userRole;
	}

	public void setUserRole(userRole userRole) {
		this.userRole = userRole;
	}
	
	
}
