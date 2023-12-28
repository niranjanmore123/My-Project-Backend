package com.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.UserAdmin;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
	
	Optional<UserAdmin> findByEmail(String email);
	Optional<UserAdmin> findByUsername(String username);
	Optional<UserAdmin> findByEmailOrUsername(String email, String username);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
