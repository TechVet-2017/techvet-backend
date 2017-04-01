package br.com.bovdog.bean;

public class ClinicalRecords {
	
	private int c_protocol;
	private String anamnesis;
	private String veterinarian;
	private String clinical_history;
	private String diagnosis;
	
	
	public int getC_protocol() {
		return c_protocol;
	}
	public void setC_protocol(int c_protocol) {
		this.c_protocol = c_protocol;
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
	

}
