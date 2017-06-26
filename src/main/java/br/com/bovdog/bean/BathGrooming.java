package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that describes the Bath and Grooming services, and contains the information and methods it requires.
 * @author adailson2, mateusvroriz
 * @version 1.0
 */

@Entity
public class BathGrooming {
	@Id
	@GeneratedValue
	private int id;
	@NotNull 
	private String serviceBathGrooming;
	@NotNull 
	private String serviceDescription;
	private int patientId;
	
	/**
	 * Method that returns the value of the id variable for the BathGrooming class.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Method that sets the value of the id variable for the BathGrooming class.
	 * @param idBathGrooming
	 */
	public void setId(int idBathGrooming){
		this.id = idBathGrooming;
	}
	
	/**
	 * Method the returns the value of the current patient's id for the BathGrooming class.
	 * @return patientId
	 */
	public int getPatientId() {
		return patientId;
	}
	
	/**
	 * Method that sets the value of the current patient's id for the BathGrooming class.
	 * @param patientId
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * Method that returns a string defining which of the services has been requested (either 'bath' or 'bath and grooming').
	 * @return
	 */
	public String getServiceBathGrooming() {
		return serviceBathGrooming;
	}
	
	/**
	 * Method that sets a string defining which of the services has been requested (either 'bath' or 'bath and grooming').
	 * @param serviceBathGrooming
	 */
	public void setServiceBathGrooming(String serviceBathGrooming){
		this.serviceBathGrooming = serviceBathGrooming;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

}
