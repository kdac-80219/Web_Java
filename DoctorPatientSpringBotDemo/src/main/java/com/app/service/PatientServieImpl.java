package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.PatientDTO;
import com.app.entities.Patient;

@Service
@Transactional
public class PatientServieImpl implements PatientService {

	@Autowired
	private PatientDao patdao;
	
	@Autowired
	private DoctorDao docdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PatientDTO addPatient(PatientDTO pt) {
		Patient pat = mapper.map(pt,Patient.class);
		Patient pat2 = patdao.save(pat);
		return mapper.map(pat2,PatientDTO.class);
	}
	
	
}
