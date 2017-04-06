package br.com.bovdog.bean;

public class ClinicalRecord {
	
	private int c_protocol;
	private int patientId;
	
	private String anamnesis;
	private String veterinarian;
	private String clinical_history;
	private String diagnosis;
	private float patientTemperature;
	private float capillaryFill;
	private String patientPulse;
	private String mucosasApparent;
	private float patientRespiratoryRate;
	private float patientHeartRate;
	
	
	public int getC_protocol() {
		return c_protocol;
	}
	public void setC_protocol(int c_protocol) {
		this.c_protocol = c_protocol;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getAnamnesis() {
		return anamnesis;
	}
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}
	public String getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(String veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getClinical_history() {
		return clinical_history;
	}
	public void setClinical_history(String clinical_history) {
		this.clinical_history = clinical_history;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public float getPatientTemperature() {
		return patientTemperature;
	}
	public void setPatientTemperature(float patientTemperature) {
		this.patientTemperature = patientTemperature;
	}
	public float getCapillaryFill() {
		return capillaryFill;
	}
	public void setCapillaryFill(float capillaryFill) {
		this.capillaryFill = capillaryFill;
	}
	public String getPatientPulse() {
		return patientPulse;
	}
	public void setPatientPulse(String patientPulse) {
		this.patientPulse = patientPulse;
	}
	public String getMucosasApparent() {
		return mucosasApparent;
	}
	public void setMucosasApparent(String mucosasApparent) {
		this.mucosasApparent = mucosasApparent;
	}
	public float getPatientRespiratoryRate() {
		return patientRespiratoryRate;
	}
	public void setPatientRespiratoryRate(float patientRespiratoryRate) {
		this.patientRespiratoryRate = patientRespiratoryRate;
	}
	public float getPatientHeartRate() {
		return patientHeartRate;
	}
	public void setPatientHearRate(float patientHearRate) {
		this.patientHeartRate = patientHearRate;
	}
	public float getPatientWeight() {
		return patientWeight;
	}
	public void setPatientWeight(float patientWeight) {
		this.patientWeight = patientWeight;
	}
	private float patientWeight; 
	
	
	

	
	

}
