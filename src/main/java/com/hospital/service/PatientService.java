package com.hospital.service;

import java.util.List;

import com.hospital.entity.Patient;

public interface PatientService {
	
	public Patient addPatient(Patient patient);
	public List<Patient> getAllPatients();
	public Patient getPatient(long id);
	public void deletePatientById(long id);
	public Patient updatePatientById(Patient patient);

}
