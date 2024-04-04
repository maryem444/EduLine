package com.example.perfectionnement.eduLine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.enums.userRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findFirstByEmail(String email);

	User findByUserRole(userRole admin);
}
