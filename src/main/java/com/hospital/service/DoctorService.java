package com.hospital.service;

import java.util.List;

import com.hospital.entity.Doctor;

public interface DoctorService {
	
	public Doctor addDoctor(Doctor doctor);
	public List<Doctor> getAllDoctors();
	public Doctor getDoctor(long id);
	public void deleteDoctorById(long id);
	public Doctor updateDoctorById(Doctor doctor);

}
