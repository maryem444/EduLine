package com.example.perfectionnement.eduLine.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.perfectionnement.eduLine.dto.AuthenticationResponse;
import com.example.perfectionnement.eduLine.dto.AutheticationRequest;
import com.example.perfectionnement.eduLine.dto.SignupRequest;
import com.example.perfectionnement.eduLine.dto.UserDto;
import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.enums.userRole;
import com.example.perfectionnement.eduLine.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;

import com.example.perfectionnement.eduLine.services.Auth.AuthService;
import com.example.perfectionnement.eduLine.services.jwt.UserService;
import com.example.perfectionnement.eduLine.utils.JWTUtil;

@RestController
@RequestMapping("/api/auth") 
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private JWTUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupCustomer (@RequestBody SignupRequest signupRequest) {
	if (authService.hasCostomerWithEmail(signupRequest.getEmail())) {
		return new ResponseEntity<>("Customer already exist with this email",HttpStatus.NOT_ACCEPTABLE);
	}
	UserDto createdCustomerDto = authService.createCustomer(signupRequest) ;
	if (createdCustomerDto == null) return new ResponseEntity<>
	("Customer not created, Come again later", HttpStatus.BAD_REQUEST);
	return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
}

	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AutheticationRequest authenticationRequest) throws
	        BadCredentialsException,
	        DisabledException,
	        UsernameNotFoundException {
	    System.out.println("Before checking account lock status");

	    Optional<User> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getEmail());

	    System.out.println("After checking account lock status");
	    if (optionalUser.isPresent()) {
	        System.out.println("dacc");
	        // authenticationRequest.setPassword(new BCryptPasswordEncoder().encode(authenticationRequest.getPassword()));
	        System.out.println(optionalUser.get().getPassword());
	        System.out.println(authenticationRequest.getPassword());
	        if (new BCryptPasswordEncoder().matches(authenticationRequest.getPassword(), optionalUser.get().getPassword())) {
	            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
	            authenticationResponse.setUserId(optionalUser.get().getId());
	            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
	            System.out.println("ok");
	            return ResponseEntity.ok(authenticationResponse);
	        }
	    }

	    // Incorrect Username or password.
	    return ResponseEntity.badRequest().body("Incorrect Username or password.");
	

	    /*try {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                authenticationRequest.getEmail(),
	                authenticationRequest.getPassword()));
	    } catch (BadCredentialsException e) {
	        throw new BadCredentialsException("Incorrect Username or password.");
	    }

	    final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
	    Optional<User> optionalUser1 = userRepository.findFirstByEmail(userDetails.getUsername());
	    final String jwt = jwtUtil.generateToken(userDetails);
	    AuthenticationResponse authenticationResponse = new AuthenticationResponse();
	    if (optionalUser1.isPresent()) {
	        authenticationResponse.setJwt(jwt);
	        authenticationResponse.setUserId(optionalUser1.get().getId());
	        authenticationResponse.setUserRole(optionalUser1.get().getUserRole());
	    }
	    return authenticationResponse;*/
	}
	
	
}

