package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;


@Service
public class PatientServiceImplementation implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return this.patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return this.patientRepository.findAll();
	}

	@Override
	public Patient getPatient(long id) {
		// TODO Auto-generated method stub
		return this.patientRepository.findById(id).get();
	}

	@Override
	public void deletePatientById(long id) {
		// TODO Auto-generated method stub
		this.patientRepository.deleteById(id);
		
	}

	@Override
	public Patient updatePatientById(Patient patient) {
		// TODO Auto-generated method stub
		return this.patientRepository.save(patient);
	}

}
