package com.example.perfectionnement.eduLine.dto;


import lombok.Data;

@Data
public class AutheticationRequest {
	
	private String Email;
	private String Password;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	


}
