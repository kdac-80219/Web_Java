package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appoint;
	
	public AppointmentController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	@PostMapping("/add")
	public String addNewAppointment(@RequestBody AppointmentDTO app)
	{
		return appoint.addAppointment(app);
	}
	
	@DeleteMapping("/{appointmentId}")
	public String deleteAppointment(@PathVariable Long appointmentId)
	{
		return appoint.deleteAppointmentById(appointmentId);
	}
	
	@GetMapping("/doctor/{doctorId}")
	public List<Appointment> getAllAppointments(@PathVariable Long doctorId)
	{
		return appoint.getAllAppointmentsByDrId(doctorId);
	}
	*/
	
	@PostMapping("/add")
	public String addAppointment(@RequestBody AppointmentDTO appointmentDto)
	{
		return appoint.addNewAppointment(appointmentDto);
	}
	
	@DeleteMapping("/{appointmentId}")
	public String deleteAppointment(@PathVariable Long appointmentId)
	{
		return appoint.deleteAppointmentById(appointmentId);
	}
	
	@GetMapping("/doctor/{doctorId}")
	public List<Appointment>getAllAppointment(@PathVariable Long doctorId)
	{
		return appoint.getAllAppointmentByDrId(doctorId);
	}
}
