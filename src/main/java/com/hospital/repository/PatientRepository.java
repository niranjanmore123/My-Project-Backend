package com.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Query(value = "select * from Patient where name = ?1", nativeQuery = true)
	public List<Patient> getPatientByName(String name);

	public Optional<Patient> findByName(String name);
}
