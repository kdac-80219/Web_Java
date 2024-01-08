package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="appointment")
@Getter
@Setter
public class Appointment extends BaseEntity{

	@Column(name="Date_Time" )
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(LocalDate date) {
		super();
		this.date = date;
	}

	
}
