package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.DoctorDTO;
import com.app.entities.Doctor;
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao docDao;
	
	@Autowired 
	private PatientDao patDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public DoctorDTO addNewDoctor(DoctorDTO dr) {
		Doctor doc = mapper.map(dr, Doctor.class);
		Doctor doc2 = docDao.save(doc);
		return mapper.map(doc2, DoctorDTO.class);
	}
	
	
}
