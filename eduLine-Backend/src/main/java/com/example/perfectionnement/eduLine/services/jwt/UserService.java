package com.example.perfectionnement.eduLine.services.jwt;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.perfectionnement.eduLine.entity.User;

public interface UserService {

	UserDetailsService userDetailsService();
	Optional<User> findById(Long userId);
}
