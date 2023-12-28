package com.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	@Query(value = "select * from Doctor where name = ?1", nativeQuery = true)
	public List<Doctor> getDoctorByName(String name);

	public Optional<Doctor> findByName(String name);
}
