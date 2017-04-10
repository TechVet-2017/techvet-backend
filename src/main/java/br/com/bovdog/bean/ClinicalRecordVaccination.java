package br.com.bovdog.bean;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ClinicalRecordVaccination extends ClinicalRecord {
	
	private Date vaccinationApplicationDate;
	private String vaccinationName;
	private Date vaccinationReturnDate;
	private String vaccinationLaboratory;
	private Date vermifugationApplicationDate;
	private String vermifugeName;
	private String vermifugeDosage;
	private Date vermifugationReturnDate;
	
	public Date getVaccinationApplicationDate() {
		return vaccinationApplicationDate;
	}
	public void setVaccinationApplicationDate(Date vaccinationApplicationDate) {
		this.vaccinationApplicationDate = vaccinationApplicationDate;
	}
	public String getVaccinationName() {
		return vaccinationName;
	}
	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}
	public Date getVaccinationReturnDate() {
		return vaccinationReturnDate;
	}
	public void setVaccinationReturnDate(Date vaccinationReturnDate) {
		this.vaccinationReturnDate = vaccinationReturnDate;
	}
	public String getVaccinationLaboratory() {
		return vaccinationLaboratory;
	}
	public void setVaccinationLaboratory(String vaccinationLaboratory) {
		this.vaccinationLaboratory = vaccinationLaboratory;
	}
	public Date getVermifugationApplicationDate() {
		return vermifugationApplicationDate;
	}
	public void setVermifugationApplicationDate(Date vermifugationApplicationDate) {
		this.vermifugationApplicationDate = vermifugationApplicationDate;
	}
	public String getVermifugeName() {
		return vermifugeName;
	}
	public void setVermifugeName(String vermifugeName) {
		this.vermifugeName = vermifugeName;
	}
	public String getVermifugeDosage() {
		return vermifugeDosage;
	}
	public void setVermifugeDosage(String vermifugeDosage) {
		this.vermifugeDosage = vermifugeDosage;
	}
	public Date getVermifugationReturnDate() {
		return vermifugationReturnDate;
	}
	public void setVermifugationReturnDate(Date vermifugationReturnDate) {
		this.vermifugationReturnDate = vermifugationReturnDate;
	}
	
}
