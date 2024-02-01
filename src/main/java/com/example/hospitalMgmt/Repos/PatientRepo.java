package com.example.hospitalMgmt.Repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.hospitalMgmt.Models.Patient;

@Repository
public class PatientRepo {
	
	Logger logger=LoggerFactory.getLogger(PatientRepo.class);
	
//Parameters : a database url of the form jdbc:subprotocol:subname
//	Understanding DriverManager.getConnection():
//
//		It's a Java method, not specific to Spring Boot, for establishing a database connection manually.
//		It's part of the java.sql.DriverManager class.
//		It takes a JDBC URL, username, and password as arguments.
//		It returns a Connection object representing the database connection.
//		Example in Spring Boot:
	
//		Statement is a core interface in the JDBC API for executing SQL statements against a database.	
//	PreparedStatement is another Interface in JDBC used to execute parameterized SQL statements against a database.	
//Dynamic query - is pref becoz only parameter changes so it never needs to compile whole query
	
	private static Connection con;
	public PatientRepo() throws SQLException{
		logger.info("Inside PatientRepo Constructor");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentinfo", "root", "1234");
		Statement stmt=con.createStatement();
		logger.info("Statement Created");
		String sqlQuery="create table if not exists patient_info(id int primary key auto_increment,name varchar(40), age int, doctorName varchar(40))";
		boolean val=stmt.execute(sqlQuery);
	}
	
//		In above URL mysql is the RDBMS, localhost or 127.0.0.1 is the IP for local server
//		3306 is the port number for mysql, studentinfo is the db name	
	

	public void insertPatient(Patient patient) throws SQLException {
		
		//TODO : adds sql queries to add patient details to DB.
		//Repo file consists of all the SQL queries.
		logger.info("Inside insertPatient Method in Repo Class");
		//Auto_increment in sql adds 1 to the largest id found in the column id(Integer)
		String sqlQuery="Insert into patient_info(name,age,doctorName) values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sqlQuery);
		
		ps.setString(1, patient.getName());
		ps.setInt(2, patient.getAge());
		ps.setString(3, patient.getDoctorName());
		
		int val=ps.executeUpdate();//returns the count of the row after updating.
		
		//ResultSet rs=ps.executeUpdate();  //Resultset will contain table data.
		logger.info("patient got inserted with value "+val);
		
		//DDL -> Data Defination Lang - Create, Alter, Drop, Show, use
		//DML ->  Data Manipulation Lang - Update, select, insert, delete
		//There are mainly 3 types of methods in Statement class to execute:
		//1) execute - will return true if result set else false.Mostly used with SELECT query.
		//2) executeUpdate - returns no of row affected.Mostly used with ALTER, INSERT, UPDATE.
		//3) executeQuery - returns the actual result. Mostly used with SELECT query
	}
	
	
public List<Patient> getAllPatient() throws SQLException {
		
		String sqlQuery = "Select * from patient_info";
		
		List<Patient> list = new ArrayList<>();
		
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery(sqlQuery);
		
		while(rs.next()) {
			
			long pId = rs.getLong("id");
			String pname = rs.getString("name");
			int age = rs.getInt("age");
			String dName = rs.getString("doctorName");
			
			Patient patient = new Patient(pId,pname,age,dName);
			
//			Patient patient = new Patient();
//			patient.setAge(age);
			
			list.add(patient);
				
		}
		return list;
	}
	
public boolean deletePatient(int id) throws SQLException {
	
	String sqlQuery = "delete from patient_info where id = " + id;
	
	Statement stmnt = con.createStatement();
	int val = stmnt.executeUpdate(sqlQuery);
	
	logger.info("deletePatient id " + id);
	
	if(val > 0) {
		return true;
	}
	
	return false;
}

}
