package br.com.bovdog.bean;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

// create Patient object.
@XmlRootElement
public class Patient { 
	private String name;
	private String species;
	private String race;
	private char size;
	private char gender;
	private Date birthDate;
	private String furCharacteristics;
	private float weight;
	
	// getters and setters for Patients attributes.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFurCharacteristics() {
		return furCharacteristics;
	}
	public void setFurCharacteristics(String furCharacteristics) {
		this.furCharacteristics = furCharacteristics;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
