package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.AppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Patient;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private DoctorDao docdao;
	
	@Autowired
	private PatientDao patdao;
	
	@Autowired
	private AppointmentDao appdao;
	
	@Autowired
	private ModelMapper mapper;
	
	
//	@Override
//	public String addAppointment(AppointmentDTO appdto) {
//		String msg = "Data not added!!!!";
//		
//		Doctor doc = docdao.findById(appdto.getDoctorId()).orElseThrow();
//		Patient pat = patdao.findById(appdto.getPatientId()).orElseThrow();
//		Appointment app = mapper.map(appdto,Appointment.class);
//		app.setDoctor(doc);
//		app.setPatient(pat);
//		
//		 mapper.map(appdao.save(app),AppointmentDTO.class);
//		 msg = "Appointment added!!!!";
//		 return msg;
//	}
	
	@Override
	public String addNewAppointment(AppointmentDTO appointmentDto) {
		Doctor doc = docdao.findById(appointmentDto.getDoctorId()).orElseThrow();
		Patient pat = patdao.findById(appointmentDto.getPatientId()).orElseThrow();
		
		Appointment appo = mapper.map(appointmentDto, Appointment.class);
		appo.setDoctor(doc);
		appo.setPatient(pat);
		mapper.map(appdao.save(appo),AppointmentDTO.class);
		return "Appointment added!!!";
	}
	
//	@Override
//	public String deleteAppointmentById(Long appointmentId) {
//		String msg = "Appointment Not Found!!";
//		if(appdao.existsById(appointmentId))
//		{
//			appdao.deleteById(appointmentId);
//			msg = "Appointment Deleted!!";
//			return msg;
//		}
//		return msg;
//	}
	
	 @Override
	public String deleteAppointmentById(Long appointmentId) {
		 String msg = "Appointment not found!!!";
		 if(appdao.existsById(appointmentId))
		 {
			 appdao.deleteById(appointmentId);
			 msg = "Appointment Cancelled!!!!";
			 return msg;
		 }
		 return msg;
	}
	
//	
//	@Override
//	public List<Appointment> getAllAppointmentsByDrId(Long doctorId) {
//		Doctor doctor = docdao.findById(doctorId).orElseThrow();
//		return appdao.findByDoctor(doctor)
//					 .stream()
//					 .map(appointment->mapper.map(appointment, Appointment.class))
//					 .collect(Collectors.toList());
//	}
	 
	 @Override
	public List<Appointment> getAllAppointmentByDrId(Long doctorId) {
		Doctor doc = docdao.findById(doctorId).orElseThrow();
		return appdao.findByDoctor(doc)
				.stream()
				.map(appointment->mapper.map(appointment,Appointment.class))
				.collect(Collectors.toList());
	}
	
}
