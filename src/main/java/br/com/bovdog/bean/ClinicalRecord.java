package br.com.bovdog.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class ClinicalRecord { // Creating clinical record class and setting it's parameters


    @Id
    @GeneratedValue
    private int id;
    private int patientId;

    private String anamnesis;
    private String veterinarian;
    private String clinicalHistory;
    private String diagnosis;
    private float patientTemperature;
    private float capillaryFill;
    private String patientPulse;
    private String mucosasApparent;
    private String hydrationState;
    private float patientRespiratoryRate;
    private float patientHeartRate;
    private float patientWeight;

    // Getters and setters for clinical record attributes.
    public int getId() {
        return this.id;
    }

    public void setId(int clinicalRecordId) {
        this.id = clinicalRecordId;
    }

    public int getPatientId() {
        return this.patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAnamnesis() {
        return this.anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getVeterinarian() {
        return this.veterinarian;
    }

    public void setVeterinarian(String veterinarian) {
        this.veterinarian = veterinarian;
    }

    public String getClinicalHistory() {
        return this.clinicalHistory;
    }

    public void setClinicalHistory(String clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public float getPatientTemperature() {
        return this.patientTemperature;
    }

    public void setPatientTemperature(float patientTemperature) {
        this.patientTemperature = patientTemperature;
    }

    public float getCapillaryFill() {
        return this.capillaryFill;
    }

    public void setCapillaryFill(float capillaryFill) {
        this.capillaryFill = capillaryFill;
    }

    public String getPatientPulse() {
        return this.patientPulse;
    }

    public void setPatientPulse(String patientPulse) {
        this.patientPulse = patientPulse;
    }

    public String getMucosasApparent() {
        return this.mucosasApparent;
    }

    public void setMucosasApparent(String mucosasApparent) {
        this.mucosasApparent = mucosasApparent;
    }

    public String getHydrationState() {
		return hydrationState;
	}

	public void setHydrationState(String hydrationState) {
		this.hydrationState = hydrationState;
	}

	public float getPatientRespiratoryRate() {
        return this.patientRespiratoryRate;
    }

    public void setPatientRespiratoryRate(float patientRespiratoryRate) {
        this.patientRespiratoryRate = patientRespiratoryRate;
    }

    public float getPatientHeartRate() {
        return this.patientHeartRate;
    }

    public void setPatientHeartRate(float patientHearRate) {
        this.patientHeartRate = patientHearRate;
    }

    public float getPatientWeight() {
        return this.patientWeight;
    }

    public void setPatientWeight(float patientWeight) {
        this.patientWeight = patientWeight;
    }

}
