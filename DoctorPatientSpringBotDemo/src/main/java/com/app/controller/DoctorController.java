package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDTO;
import com.app.entities.Doctor;
import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService docService;
	public DoctorController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add")
	public DoctorDTO addDoctor(@RequestBody DoctorDTO dr)
	{
		return docService.addNewDoctor(dr);
	}
	
	
}
