package com.example.hospitalMgmt.Models;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter                       //create getter methods - part of Lombok Dependency
//@Setter                       //create setter methods - part of Lombok Dependency
//@AllArgsConstructor           //create all argument constructor - part of Lombok Dependency
//@NoArgsConstructor            //create nos argument constructor - part of Lombok Dependency

//imported from Jakarta instead of Hibernate as @Table in that got deprecated
//Jakarta in this is also implementation of JPA. 
//Jakarta Persistence Api - @Column, @Entity, @Table, @Id
//JPA(Java Persistence API) interface methods - get(), save(), update(), find(), delete()
//Hibernate is implementor of Spring Data JPA
//For different Kind of Nosql databases like MongoDB, Cassandra, CouchDB, different maven 
//dependencies will be added in pom.
//whereas in Rdbms, there will be same dependency for all databases of JPA.

//@Entity			//@Entity represents that the class is a JPA entity, representing a table in the database.
//@Entity can work alone to define a class as a Database table
//we use @Table alongwith @Entity when we want to customize the name of the db table 
//other than the class name. 
//if we use only @Table, then it will give error.
//@Table(name="myBookTable")  //On app startup name field value would be as specified. 
public class Patient {

	
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Patient(long patientId, String name, int age, String doctorName) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.doctorName = doctorName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	//@Id				//It is used to create primary key.
	//IDENTITY - auto increment will be taken care by mysql.
	//Auto - auto increment will be taken care by hibernate
	//@GeneratedValue(strategy=GenerationType.IDENTITY)  //used for Auto-Increment.
	long patientId;  //patient_Id
	String name;  //name
	private int age;  //age
	//@Column(name="DoctorName") 		//Use to provide Custom Name to the Column
	String doctorName;  //doctor_Name
	
}
