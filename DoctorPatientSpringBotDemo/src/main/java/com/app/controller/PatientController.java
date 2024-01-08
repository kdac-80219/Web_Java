package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDTO;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService pservice;
	
	public PatientController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add")
	public PatientDTO addNewPatient(@RequestBody PatientDTO pt)
	{
		return pservice.addPatient(pt);
	}
}
