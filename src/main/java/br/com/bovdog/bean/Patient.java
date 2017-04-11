package br.com.bovdog.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// create Patient object.
@Entity
public class Patient {
	
	// notation to identify primary key and auto increment the same
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// notation to set not null columns attributes
	@Column(nullable = false)
	private String patientName;
	@Column(nullable = false)
	private String specie;
	@Column(nullable = false)
	private String breed;
	private char size;
	private char gender;
	@Column(nullable = true)
	private Date birthday;
	@Column(nullable = false)
	private String coat;
	
	// getters and setters for Patients attributes.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public char getSize() {
		return size;
	}
	public void setSize(char size) {
		this.size = size;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCoat() {
		return coat;
	}
	public void setCoat(String coat) {
		this.coat = coat;
	}
	
}
