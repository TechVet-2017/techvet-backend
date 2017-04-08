package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BathGrooming {
	@Id
	@GeneratedValue
	private int idBathGrooming;
	private String serviceBathGrooming;
	
	public int getIdBathGrooming() {
		return idBathGrooming;
	}
	public void setIdBathGrooming(int idBathGrooming){
		this.idBathGrooming = idBathGrooming;
	}
	
	public String getServiceBathGrooming() {
		return serviceBathGrooming;
	}
	public void setServiceBathGrooming(String serviceBathGrooming){
		this.serviceBathGrooming = serviceBathGrooming;
	}

}
