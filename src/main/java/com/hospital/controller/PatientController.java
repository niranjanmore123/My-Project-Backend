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

import com.hospital.entity.Patient;
import com.hospital.exception.InvalidPatientIdException;
import com.hospital.exception.InvalidPatientNameException;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRepository patientRepository;
	
	HashMap<String, String> response = new HashMap<>();

	@PostMapping("/patient")
	public Patient addNewPatientRecord(@Valid @RequestBody Patient patient) {
		response.put("message", "Patient record added Successfully...!!!");
		return this.patientService.addPatient(patient);
	}

	@GetMapping("/patients")
	public List<Patient> findAllPatients() {
		return this.patientService.getAllPatients();
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<?> findPatientById(@PathVariable long id) throws InvalidPatientIdException {
		if (this.patientRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(this.patientService.getPatient(id), HttpStatus.OK);
		} else {

			throw new InvalidPatientIdException("Patient id not found...!!!");
		}
	}
	
	@GetMapping("/patient/name") 
    public ResponseEntity<?> getPatientByName(@RequestParam("name") String name) throws InvalidPatientNameException
    {
		if (this.patientRepository.findByName(name).isPresent()) {
			return new ResponseEntity<>(this.patientRepository.getPatientByName(name),HttpStatus.OK);
		} else {

			throw new InvalidPatientNameException("Patient name not found...!!!");
		}
        
    }
	

	@PatchMapping("/patient/{id}")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient, @PathVariable long id) {
		
		if (this.patientRepository.findById(id).isPresent()) {
			Patient existingObj = this.patientRepository.findById(id).get();

			if (patient.getName() != null) {
				existingObj.setName(patient.getName());
			}

			if (patient.getAge()!=0) {
				existingObj.setAge(patient.getAge());
			}
			
			if (patient.getMobileNo()!=null) {
				existingObj.setMobileNo(patient.getMobileNo());
			}
			
			if (patient.getAddress()!=null) {
				existingObj.setAddress(patient.getAddress());
			}
			
			if (patient.getGender()!=null) {
				existingObj.setGender(patient.getGender());
			}
			
			if (patient.getBloodGroup()!=null) {
				existingObj.setBloodGroup(patient.getBloodGroup());
			}
			
			if (patient.getDisease()!=null) {
				existingObj.setDisease(patient.getDisease());
			}
			
			if (patient.getFees()!=0.0) {
				existingObj.setFees(patient.getFees());
			}
			

			this.patientService.updatePatientById(existingObj);
			response.put("message", "Patient record updated Successfully..!!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("message", "Patient id not found...!!!");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable long id)
	{
		if(this.patientRepository.findById(id).isPresent())
		{
			this.patientService.deletePatientById(id);
			response.put("message", "Patient record deleted Successfully...!!!");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else
		{
			response.put("message", "Patient id not found...!!!");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

}
