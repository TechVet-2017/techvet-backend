package br.com.bovdog.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BathGrooming {
	@Id
	@GeneratedValue
	private int id;
	private String serviceBathGrooming;
	
	// create relationship between bathAndGrooming and patient
	@OneToMany(mappedBy="bathGrooming")
	private List<Patient> patients;
	
	// getters and setters for BathGrooming attributes.
	public int getId() {
		return id;
	}
	public void setId(int idBathGrooming){
		this.id = idBathGrooming;
	}
	
	public String getServiceBathGrooming() {
		return serviceBathGrooming;
	}
	public void setServiceBathGrooming(String serviceBathGrooming){
		this.serviceBathGrooming = serviceBathGrooming;
	}

}
