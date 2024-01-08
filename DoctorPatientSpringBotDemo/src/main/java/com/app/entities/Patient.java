package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="patient")
@Getter
@Setter

public class Patient extends BaseEntity {
	@Column(name="patient_name" ,length=50)
	private String patName;
	@Column(length=50)
	private String email;
	
	public Patient() {
		super();
	}
	
	public Patient(String patName, String email) {
		super();
		this.patName = patName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [patName=" + patName + ", email=" + email + "]";
	}
	
	
	
}
