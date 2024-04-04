package com.example.perfectionnement.eduLine.services.Auth;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.perfectionnement.eduLine.dto.SignupRequest;
import com.example.perfectionnement.eduLine.dto.UserDto;
import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.enums.userRole;
import lombok.RequiredArgsConstructor;
import com.example.perfectionnement.eduLine.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	public void createAdminAccount() {
		User adminAccount = userRepo.findByUserRole(userRole.ADMIN);
		if(adminAccount == null) {
			User newAdminAccount = new User();
			newAdminAccount.setFirstName("Admin");
			newAdminAccount.setLastName("Admin");
			newAdminAccount.setEmail("admin@test.com");
			newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
			newAdminAccount.setUserRole(userRole.ADMIN);
			userRepo.save(newAdminAccount);
			System.out.println("Admin account created successfully");
		}
	}
	@Override
	@Transactional
	public UserDto createCustomer(SignupRequest signupRequest) {
		User user = new User();
		user.setFirstName(signupRequest.getFirstName());
		user.setLastName(signupRequest.getLastName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setUserRole(userRole.CUSTOMER);
		User createUser= userRepo.save(user);
		UserDto userDto = new UserDto();
		userDto.setId(createUser.getId());
		return userDto;
	}

	@Override
	public boolean hasCostomerWithEmail(String email) {
		return userRepo.findFirstByEmail(email).isPresent();
	}

}
