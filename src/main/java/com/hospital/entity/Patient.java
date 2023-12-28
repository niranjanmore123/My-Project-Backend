package com.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Patient name cannot be null...")
	private String name;
	
	@NotNull(message="Age cannot be empty...")
	private int age;
	
	@NotNull(message="Mobile No. cannot be empty")
	@Size(max = 10, message="Mobile No. cannot be more than 10 digits")
	private String mobileNo;
	
	@NotEmpty(message="Address cannot be empty")
	@Size(max = 1000, message="Address cannot be more than 1000 words...")
	private String address;
	
	private String gender;
	
	@NotEmpty(message="Blood Group cannot be empty")
	private String bloodGroup;
	
	@NotEmpty(message="Please specify at least one Disease...")
	private String disease;
	
	@Min(value=50, message="Checking fees more than 50 Rupees...")
	private double fees;

}
