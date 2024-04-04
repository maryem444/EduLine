package com.example.perfectionnement.eduLine.services.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return userRepository.findFirstByEmail(username)
						.orElseThrow(()-> new UsernameNotFoundException("User not found"));
			}
		};
	}

	@Override
	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
