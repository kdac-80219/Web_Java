package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="doctor")
@Getter
@Setter
public class Doctor extends BaseEntity{
	@Column(name="doctor_name",length=50)
	private String doctorName;
	@Column(unique = true,length=50)
	private String email;
	
	public Doctor() {

	}

	public Doctor(String doctorName, String email) {
		super();
		this.doctorName = doctorName;
		this.email = email;
	}
	
	
	
}
