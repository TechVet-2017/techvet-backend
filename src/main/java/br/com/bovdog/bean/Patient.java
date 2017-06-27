package br.com.bovdog.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Class that describes the Patients of the system. The patients refer to the animals being treated in the clinic.
 * 
 * @author leomeister, flavio
 * @version 1.0
 *
 */
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
	
	// create relationship between owner and patient
	private int patientOwnerId;

	/**
	 * Method that returns the value of the id variable for the BPatients class.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method that sets the value of the patient's id.
	 * @param id patient's id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method the returns the value of the current patient's name.
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Sets the patient's name.
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * Returns the species of the patient.
	 * @return
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Sets the species of the patient.
	 * @param species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Returns the breed of the patient.
	 * @return
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Sets the Breed of the Patient.
	 * @param breed
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * Returns the size of the patient.
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size of the patient.
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Returns the gender of the patient.
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the patient.
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the date of birth of the patient.
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the date of birth of the patient.
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Returns the color of the patient's fur.
	 * @return
	 */
	public String getCoat() {
		return coat;
	}

	/**
	 * Sets the color of the patient's fur.
	 * @param coat
	 */
	public void setCoat(String coat) {
		this.coat = coat;
	}
	
	/**
	 * Return the id of the patient's owner in the system.
	 * @return
	 */
	public int getPatientOwnerId() {
		return patientOwnerId;
	}

	/**
	 * Sets the id of the patient's owner in the system.
	 * @param ownerId
	 */
	public void setPatientOwnerId(int ownerId) {
		this.patientOwnerId = ownerId;
	}
	
}