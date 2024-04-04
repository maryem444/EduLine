package com.example.perfectionnement.eduLine.services.Auth;

import org.springframework.stereotype.Service;

import com.example.perfectionnement.eduLine.dto.SignupRequest;
import com.example.perfectionnement.eduLine.dto.UserDto;

@Service
public interface AuthService {
	
	UserDto createCustomer(SignupRequest signupRequest);
	boolean hasCostomerWithEmail(String email);
}
