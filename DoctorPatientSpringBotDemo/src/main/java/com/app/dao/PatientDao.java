package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Patient;

public interface PatientDao extends JpaRepository<Patient,Long> {

}
