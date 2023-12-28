package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;

@Service
public class DoctorServiceImplementation implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return this.doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctor(long id) {
		// TODO Auto-generated method stub
		return this.doctorRepository.findById(id).get();
	}

	@Override
	public void deleteDoctorById(long id) {
		// TODO Auto-generated method stub
		this.doctorRepository.deleteById(id);
	}

	@Override
	public Doctor updateDoctorById(Doctor doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.save(doctor);
	}

}
