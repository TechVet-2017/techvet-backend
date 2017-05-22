package br.com.bovdog.bean;

import javax.persistence.Entity;

@Entity
public class ClinicalRecordAppointment extends ClinicalRecord { // Creating clinical record appointment class inheriting from ClinicalRecord class

    private String clinicalProcedure;
    private String observations;
    private String exam;
    private String informations;
    private String preliminaryMedication;
    private float medicationDosage;
    private String medicationFrequency;
    private String diagnostic;
    private String prognostic;
    private String prognosticDetails;
    private String homeMedicationName;
    private String homeMedicationDosage;
    private String homeMedicationFrequency;
    private String clinicMedicationName;
    private String clinicMedicationDosage;
    private String clinicMedicationFrequency;

    // Getters and setters for clinical record appointment attributes.
    public String getClinicalProcedure() {
        return this.clinicalProcedure;
    }
    public void setClinicalProcedure(String procedure) {
        this.clinicalProcedure = procedure;
    }
    public String getObservations() {
        return this.observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public String getExam() {
        return this.exam;
    }
    public void setExam(String exam) {
        this.exam = exam;
    }
    public String getInformations() {
        return this.informations;
    }
    public void setInformations(String informations) {
        this.informations = informations;
    }
    public String getPreliminaryMedication() {
        return this.preliminaryMedication;
    }
    public void setPreliminaryMedication(String preliminaryMedication) {
        this.preliminaryMedication = preliminaryMedication;
    }
    public float getMedicationDosage() {
        return this.medicationDosage;
    }
    public void setMedicationDosage(float medicationDosage) {
        this.medicationDosage = medicationDosage;
    }
    public String getMedicationFrequency() {
        return this.medicationFrequency;
    }
    public void setMedicationFrequency(String medicationFrequency) {
        this.medicationFrequency = medicationFrequency;
    }
    public String getDiagnostic() {
        return this.diagnostic;
    }
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }
    public String getPrognostic() {
        return this.prognostic;
    }
    public void setPrognostic(String prognostic) {
        this.prognostic = prognostic;
    }
    public String getHomeMedicationName() {
        return this.homeMedicationName;
    }
    public void setHomeMedicationName(String homeMedicationName) {
        this.homeMedicationName = homeMedicationName;
    }
    public String getHomeMedicationDosage() {
        return this.homeMedicationDosage;
    }
    public void setHomeMedicationDosage(String homeMedicationDosage) {
        this.homeMedicationDosage = homeMedicationDosage;
    }
    public String getHomeMedicationFrequency() {
        return this.homeMedicationFrequency;
    }
    public void setHomeMedicationFrequency(String homeMedicationFrequency) {
        this.homeMedicationFrequency = homeMedicationFrequency;
    }
    public String getClinicMedicationName() {
        return this.clinicMedicationName;
    }
    public void setClinicMedicationName(String clinicMedicationName) {
        this.clinicMedicationName = clinicMedicationName;
    }
    public String getClinicMedicationDosage() {
        return this.clinicMedicationDosage;
    }
    public void setClinicMedicationDosage(String clinicMedicationDosage) {
        this.clinicMedicationDosage = clinicMedicationDosage;
    }
    public String getClinicMedicationFrequency() {
        return this.clinicMedicationFrequency;
    }
    public void setClinicMedicationFrequency(String clinicMedicationFrequency) {
        this.clinicMedicationFrequency = clinicMedicationFrequency;
    }
	public String getPrognosticDetails() {
		return prognosticDetails;
	}
	public void setPrognosticDetails(String prognosticDetails) {
		this.prognosticDetails = prognosticDetails;
	}

}
