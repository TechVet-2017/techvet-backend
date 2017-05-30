package br.com.bovdog.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// create Patient object.
@Entity
public class Patient {

	// notation to identify primary key and auto increment the same
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// notation to set not null columns attributes
	@Column(nullable = true)
	private String patientName;
	@Column(nullable = false)
	private String species;
	@Column(nullable = true)
	private String breed;
	private String size;
	private String gender;
	@Column(nullable = false)
	private Date birthday;
	@Column(nullable = false)
	private String coat;
	
	@OneToMany
	private Collection<Owner> owners = new ArrayList<>();
	
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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
