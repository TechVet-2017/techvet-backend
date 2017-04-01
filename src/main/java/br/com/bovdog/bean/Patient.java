package br.com.bovdog.bean;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

// create Patient object.
@XmlRootElement
public class Patient { 
	private int idPatient;
	private String patientName;
	private String specie;
	private String breed;
	private char size;
	private char gender;
	private Date birthday;
	private String coat;
	
	// getters and setters for Patients attributes.
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
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
