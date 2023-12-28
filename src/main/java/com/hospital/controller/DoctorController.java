package com.hospital.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Doctor;
import com.hospital.exception.InvalidDoctorsIDException;
import com.hospital.exception.InvalidDoctorsNameException;
import com.hospital.repository.DoctorRepository;
import com.hospital.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	HashMap<String, String> response=new HashMap<>();
	
	@PostMapping("/doctor")
	public Doctor addNewDoctorRecord(@Valid @RequestBody Doctor doctor) {
		response.put("message", "Doctors record added Successfully...!!!");
		return this.doctorService.addDoctor(doctor);
	}
	
	@GetMapping("/doctors")
	public List<Doctor> findAllBooks() {
		return this.doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<?> findDoctorById(@PathVariable long id) throws InvalidDoctorsIDException {
		if (this.doctorRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(this.doctorService.getDoctor(id), HttpStatus.OK);
		} else {

			throw new InvalidDoctorsIDException("Doctors id not found...!!!");
		}
	}
	
	@GetMapping("/doctor/name") 
    public ResponseEntity<?> getPatientByName(@RequestParam("name") String name) throws InvalidDoctorsNameException
    {
		if (this.doctorRepository.findByName(name).isPresent()) {
			return new ResponseEntity<>(this.doctorRepository.getDoctorByName(name),HttpStatus.OK);
		} else {

			throw new InvalidDoctorsNameException("Doctors name not found...!!!");
		}
        
    }
	
	
	@PatchMapping("/doctor/{id}")
	public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor, @PathVariable long id) {
		
		if (this.doctorRepository.findById(id).isPresent()) {
			Doctor existingObj = this.doctorRepository.findById(id).get();

			if (doctor.getName() != null) {
				existingObj.setName(doctor.getName());
			}
			
			if (doctor.getSpecialization() != null) {
				existingObj.setSpecialization(doctor.getSpecialization());
			}
			
			if (doctor.getEmail() != null) {
				existingObj.setEmail(doctor.getEmail());
			}
			
			if (doctor.getMobileNo() != null) {
				existingObj.setMobileNo(doctor.getMobileNo());
			}
			

			this.doctorService.updateDoctorById(existingObj);
			response.put("message", "Doctors record updated Successfully..!!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("message", "Doctors id not found...!!!");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable long id)
	{
		if(this.doctorRepository.findById(id).isPresent())
		{
			this.doctorService.deleteDoctorById(id);
			response.put("message", "Doctors record deleted Successfully...!!!");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else
		{
			response.put("message", "Doctors id not found...!!!");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	

}
