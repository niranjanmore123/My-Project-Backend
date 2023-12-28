package com.hospital.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Doctor's name cannot be null...")
	private String name;
	
	@NotEmpty(message="Doctor's specialization cannot be empty...")
	private String specialization;
	
	@NotEmpty(message="Email cannot be empty...")
	private String email;
	
	@NotNull(message="Mobile No. cannot be empty")
	@Size(max = 10, message="Mobile No. cannot be more than 10 digits")
	private String mobileNo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Patient> patients;

}
