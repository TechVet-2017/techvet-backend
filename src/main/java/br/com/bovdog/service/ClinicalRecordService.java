package br.com.bovdog.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.List;
import java.util.Date;

import br.com.bovdog.dao.ClinicalRecordDAO;
import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.bean.ClinicalRecordVaccination;

@Path("/ClinicalRecordService")
public class ClinicalRecordService {

	@POST
	@Path("/getById")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public ClinicalRecord getClinicalRecordById(@FormParam("id") int id) {
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		return dao.getClinicalRecordById(id);
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public List<ClinicalRecord> getAllClinicalRecords() {
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		return dao.getAllClinicalRecords();
	}

	@POST
	@Path("/delete")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<ClinicalRecord> deleteClinicalRecordById(@FormParam("id") int id) {
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		dao.deleteClinicalRecord(id);
		return dao.getAllClinicalRecords();
	}


	/* TODO refactor */
	@POST
	@Path("/{type:vaccination|appointment}/{method:create|update}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<ClinicalRecord> createOrUpdateClinicalRecord(
			@FormParam("clinicalRecordId") int clinicalRecordId,
			@FormParam("anamnesis") String anamnesis,
			@FormParam("veterinarian") String veterinarian,
			@FormParam("clinicalHistory") String clinicalHistory,
			@FormParam("diagnosis") String diagnosis,
			@FormParam("patientTemperature") float patientTemperature,
			@FormParam("capillaryFill") float capillaryFill,
			@FormParam("patientPulse") String patientPulse,
			@FormParam("mucosasApparent") String mucosasApparent,
			@FormParam("patientRespiratoryRate") float patientRespiratoryRate,
			@FormParam("patientHeartRate") float patientHeartRate,
			@FormParam("patientWeight") float patientWeight,
			@PathParam("method") String method,
			@PathParam("type") String type,
			@FormParam("clinicalProcedure") String clinicalProcedure,
			@FormParam("observations") String observations,
			@FormParam("exam") String exam,
			@FormParam("informations") String informations,
			@FormParam("preliminaryMedication") String preliminaryMedication,
			@FormParam("medicationDosage") float medicationDosage,
			@FormParam("medicationFrequency") String medicationFrequency,
			@FormParam("diagnostic") String diagnostic,
			@FormParam("prognostic") String prognostic,
			@FormParam("homeMedicationName") String homeMedicationName,
			@FormParam("homeMedicationDosage") String homeMedicationDosage,
			@FormParam("homeMedicationFrequency") String homeMedicationFrequency,
			@FormParam("clinicMedicationName") String clinicMedicationName,
			@FormParam("clinicMedicationDosage") String clinicMedicationDosage,
			@FormParam("clinicMedicationFrequency") String clinicMedicationFrequency,
			@FormParam("vaccinationApplicationDate") Date vaccinationApplicationDate,
			@FormParam("vaccinationName") String vaccinationName,
			@FormParam("vaccinationReturnDate") Date vaccinationReturnDate,
			@FormParam("vaccinationLaboratory") String vaccinationLaboratory,
			@FormParam("vermifugationApplicationDate") Date vermifugationApplicationDate,
			@FormParam("vermifugeName") String vermifugeName,
			@FormParam("vermifugeDosage") String vermifugeDosage,
			@FormParam("vermifugationReturnDate") Date vermifugationReturnDate
			) {

		ClinicalRecordDAO dao = new ClinicalRecordDAO();

		if (type.equalsIgnoreCase("vaccination")) {
			ClinicalRecordVaccination recordVaccination = new ClinicalRecordVaccination();
			recordVaccination.setVaccinationApplicationDate(vaccinationApplicationDate);
			recordVaccination.setVaccinationLaboratory(vaccinationLaboratory);
			recordVaccination.setVaccinationName(vaccinationName);
			recordVaccination.setVaccinationReturnDate(vaccinationReturnDate);
			recordVaccination.setVermifugationApplicationDate(vermifugationApplicationDate);
			recordVaccination.setVermifugationReturnDate(vermifugationReturnDate);
			recordVaccination.setVermifugeDosage(vermifugeDosage);
			recordVaccination.setVermifugeName(vermifugeName);
			recordVaccination.setAnamnesis(anamnesis);
			recordVaccination.setVeterinarian(veterinarian);
			recordVaccination.setClinicalHistory(clinicalHistory);
			recordVaccination.setDiagnosis(diagnosis);
			recordVaccination.setPatientTemperature(patientTemperature);
			recordVaccination.setCapillaryFill(capillaryFill);
			recordVaccination.setPatientPulse(patientPulse);
			recordVaccination.setMucosasApparent(mucosasApparent);
			recordVaccination.setPatientRespiratoryRate(patientRespiratoryRate);
			recordVaccination.setPatientHeartRate(patientHeartRate);
			recordVaccination.setPatientWeight(patientWeight);

			if (method.equalsIgnoreCase("update")) {
				recordVaccination.setClinicalRecordId(clinicalRecordId);
				dao.updateClinicalRecord(recordVaccination);
			}

			if (method.equalsIgnoreCase("create")) {
				dao.createClinicalRecord(recordVaccination);
			}


		}
		if (type.equalsIgnoreCase("appointment")) {
			ClinicalRecordAppointment recordAppointment = new ClinicalRecordAppointment();
			recordAppointment.setClinicalProcedure(clinicalProcedure);
			recordAppointment.setObservations(observations);
			recordAppointment.setExam(exam);
			recordAppointment.setInformations(informations);
			recordAppointment.setPreliminaryMedication(preliminaryMedication);
			recordAppointment.setMedicationDosage(medicationDosage);
			recordAppointment.setMedicationFrequency(medicationFrequency);
			recordAppointment.setDiagnostic(diagnostic);
			recordAppointment.setPrognostic(prognostic);
			recordAppointment.setHomeMedicationName(homeMedicationName);
			recordAppointment.setHomeMedicationDosage(homeMedicationDosage);
			recordAppointment.setHomeMedicationFrequency(homeMedicationFrequency);
			recordAppointment.setClinicMedicationName(clinicMedicationName);
			recordAppointment.setClinicMedicationDosage(clinicMedicationDosage);
			recordAppointment.setClinicMedicationFrequency(clinicMedicationFrequency);
			recordAppointment.setAnamnesis(anamnesis);
			recordAppointment.setVeterinarian(veterinarian);
			recordAppointment.setClinicalHistory(clinicalHistory);
			recordAppointment.setDiagnosis(diagnosis);
			recordAppointment.setPatientTemperature(patientTemperature);
			recordAppointment.setCapillaryFill(capillaryFill);
			recordAppointment.setPatientPulse(patientPulse);
			recordAppointment.setMucosasApparent(mucosasApparent);
			recordAppointment.setPatientRespiratoryRate(patientRespiratoryRate);
			recordAppointment.setPatientHeartRate(patientHeartRate);
			recordAppointment.setPatientWeight(patientWeight);

			if (method.equalsIgnoreCase("update")) {
				recordAppointment.setClinicalRecordId(clinicalRecordId);
				dao.updateClinicalRecord(recordAppointment);
			}

			if (method.equalsIgnoreCase("create")) {
				dao.createClinicalRecord(recordAppointment);
			}

		}

		return dao.getAllClinicalRecords();
	}
}
