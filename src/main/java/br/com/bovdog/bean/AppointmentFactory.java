package br.com.bovdog.bean;

public class AppointmentFactory implements ClinicalRecordFactory {

	@Override
	public ClinicalRecord createClinicalRecord() {
		ClinicalRecordAppointment clinicalRecordAppointment = new ClinicalRecordAppointment();
		return clinicalRecordAppointment;
	}

}
