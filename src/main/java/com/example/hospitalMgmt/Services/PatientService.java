package com.example.hospitalMgmt.Services;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalMgmt.Models.Patient;
import com.example.hospitalMgmt.Repos.PatientRepo;

@Service
public class PatientService {

	@Autowired
	PatientRepo pr;
	Logger logger=LoggerFactory.getLogger(PatientService.class);
	
	public void createPatient(Patient patient) throws SQLException {
		
		//Service file contains all the Business Logic
		if(patient.getAge()>0) {
			logger.info("Inside create Method in Service class");
		pr.insertPatient(patient);}
	}
	

	public List<Patient> getAllPatient() throws SQLException {

		return pr.getAllPatient();
		
	}
	
	public boolean deletePatient(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		return pr.deletePatient(id);
	}
}
