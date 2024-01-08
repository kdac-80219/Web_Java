package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Doctor;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

	List<Appointment>findByDoctor(Doctor doctor);
}
