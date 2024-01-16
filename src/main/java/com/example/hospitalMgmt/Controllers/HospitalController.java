package com.example.hospitalMgmt.Controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalMgmt.Models.Patient;
import com.example.hospitalMgmt.Repos.PatientRepo;
import com.example.hospitalMgmt.Services.PatientService;

@RestController
public class HospitalController {
   
	@Autowired
	PatientService sr;
	Logger logger=LoggerFactory.getLogger(HospitalController.class);
	
	@PostMapping("/createPatient")
	public void createPatient(@RequestBody Patient patient) throws SQLException {
		if(patient!=null) {
		logger.info("Inside createPatient");
		sr.createPatient(patient);
		}
	}
	
	//Flow
	//Controller -> Service -> Repo -> DB
	//Service - Business Logic
	//Repo - Queries to interact With DB
	//Controller - Endpoints to handle HTTP Requests
	//Model - will hold the object
	
	
//	@GetMapping("/getPatientDetailsById/{id}")
//	public Patient getPatientDetail(@PathVariable("id") int pId) {
//		
//		return pObj;
//	}
	@GetMapping(value = "/getAllPatientDetails")
    public List<Patient> getPatientDetail() throws SQLException{
		
		//TODO ADD A CALL TO SERVICE
		logger.info("Inside getAllPatientDetails");
		List<Patient> ls=sr.getAllPatient();
		return ls;
		
        //return pObj;
    }
	
	@DeleteMapping(value = "/deletePatient")
    public boolean deletePatient(@RequestParam("id") int id) throws SQLException{
		
		//TODO ADD A CALL TO SERVICE
		
		
		return sr.deletePatient(id);
		
        //return pObj;
    }
	
	//Create another api to update a record
	

	//Hibernate 
	
	//is a java framework/ORM used to map the java objects to rdbms SQL tables. 
	//it also called ORM(Object Relational Mapping) tool.
	//it will map the java class to sql table.
	//it will also take responsibilty of internally executing query. 
	
	
	
	//JPA is an interface -----> hibernate is a implementor of jpa
	//JPA is kind of standard contract 
	
	//JPA(Java Persistence API) methods - get(), save(), update(), find()
	
	//Hibernate will be implementing all these methods 
	
	//JPA HIBERNATE IS FOR NOSQL AND SQL BOTH ?
	// IT IS ONLY FOR SQL
}