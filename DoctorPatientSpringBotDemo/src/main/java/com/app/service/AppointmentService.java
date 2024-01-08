package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;

public interface AppointmentService {

	
	//String addAppointment(AppointmentDTO appdto);
	//String deleteAppointmentById(Long appointmentId);
	//List<Appointment> getAllAppointmentsByDrId(Long doctorId);
	String addNewAppointment(AppointmentDTO appointmentDto);
	String deleteAppointmentById(Long appointmentId);
	List<Appointment>getAllAppointmentByDrId(Long doctorId);
}
