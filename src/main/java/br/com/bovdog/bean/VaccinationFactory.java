package br.com.bovdog.bean;

public class VaccinationFactory implements ClinicalRecordFactory {

	@Override
	public ClinicalRecord createClinicalRecord() {
		ClinicalRecordVaccination clinicalRecordVaccination = new ClinicalRecordVaccination();
		return clinicalRecordVaccination;
	}

}
