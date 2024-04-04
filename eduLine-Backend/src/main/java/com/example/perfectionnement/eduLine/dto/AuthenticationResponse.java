package com.example.perfectionnement.eduLine.dto;

import com.example.perfectionnement.eduLine.enums.userRole;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	
	private userRole UserRole;

	private Long userId;

	
	public userRole getUserRole() {
		return UserRole;
	}

	public void setUserRole(userRole userRole) {
		UserRole = userRole;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


}
