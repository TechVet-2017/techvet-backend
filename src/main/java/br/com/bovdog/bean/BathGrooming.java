package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BathGrooming {
	@Id
	@GeneratedValue
	private int id;
	@NotNull 
	private String serviceBathGrooming;
	private String serviceDescription;
	private int patientId;
	
	// getters and setters for BathGrooming attributes.
	public int getId() {
		return id;
	}
	public void setId(int idBathGrooming){
		this.id = idBathGrooming;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getServiceBathGrooming() {
		return serviceBathGrooming;
	}
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
