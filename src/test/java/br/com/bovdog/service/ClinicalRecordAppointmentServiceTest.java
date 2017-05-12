package br.com.bovdog.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.bovdog.bean.AppointmentFactory;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.dao.DataAccessObject;
import br.com.bovdog.helper.PersistenceHelper;
import junit.framework.Assert;

public class ClinicalRecordAppointmentServiceTest {

	DataAccessObject dataAccessObject = DataAccessObject
			.getInstance("test-unit");
	ClinicalRecordAppointmentService clinicalRecordAppointmentService = new ClinicalRecordAppointmentService(
			dataAccessObject);

	@After
	public void cleanDatabase() {
		PersistenceHelper.clearDatabase();
	}

	public ClinicalRecordAppointment setupAppointment() {
		AppointmentFactory appointmentFactory = new AppointmentFactory();
		ClinicalRecordAppointment record = (ClinicalRecordAppointment) appointmentFactory
				.createClinicalRecord();
		record.setAnamnesis("String");
		record.setBloodPressure("String");
		record.setCapillaryFill(0);
		record.setClinicalHistory("String");
		record.setDiagnosis("String");
		record.setHydrationState("String");
		record.setLymphnodes("String");
		record.setMucosasApparent("String");
		record.setPatientHeartRate(0);
		record.setPatientId(0);
		record.setPatientPulse("String");
		record.setPatientRespiratoryRate(0);
		record.setPatientTemperature(0);
		record.setPatientWeight(0);
		record.setVeterinarian("String");
		record.setVeterinarianIdentification("String");
		record.setClinicalProcedure("String");
		record.setClinicMedicationDosage("String");
		record.setClinicMedicationFrequency("String");
		record.setClinicMedicationName("String");
		record.setDiagnostic("String");
		record.setExam("String");
		record.setHomeMedicationDosage("String");
		record.setHomeMedicationFrequency("String");
		record.setHomeMedicationName("String");
		record.setInformations("String");
		record.setMedicationDosage(0);
		record.setMedicationFrequency("String");
		record.setObservations("String");
		record.setPreliminaryMedication("String");
		record.setPrognostic("String");
		record.setPrognosticDetails("String");
		return record;
	}

	@Test
	public void creatorTest() {
		ClinicalRecordAppointmentService clinicalRecordAppointmentService = new ClinicalRecordAppointmentService();
		Assert.assertNotNull(clinicalRecordAppointmentService);
	}

	@Test
	public void getAllClinicalRecordAppointmentTest() {
		UriInfo ui = Mockito.mock(UriInfo.class);
		@SuppressWarnings("unchecked")
		MultivaluedMap<String, String> queryParameters = Mockito
				.mock(MultivaluedMap.class);
		Mockito.when(ui.getQueryParameters()).thenReturn(queryParameters);
		clinicalRecordAppointmentService.getAllClinicalRecords(ui);
		List<ClinicalRecordAppointment> appointments = new ArrayList<ClinicalRecordAppointment>();
		for (int i = 0; i < 3; i++) {
			ClinicalRecordAppointment record = setupAppointment();
			record.setVeterinarian("String " + i);
			record = dataAccessObject.createObject(record);

			appointments.add(record);

		}
		Assert.assertEquals(appointments, dataAccessObject.getAllObjects(null,
				ClinicalRecordAppointment.class));
	}

	@Test
	public void createClinicalRecordAppointmentTest() {
		ClinicalRecordAppointment clinicalRecordAppointment = setupAppointment();
		clinicalRecordAppointment = (ClinicalRecordAppointment) clinicalRecordAppointmentService
				.createClinicalRecordAppointment(clinicalRecordAppointment);

		int id = clinicalRecordAppointment.getId();
		Assert.assertEquals(clinicalRecordAppointment, dataAccessObject
				.getObjectById(id, ClinicalRecordAppointment.class));

	}

	@Test
	public void updateClinicalRecordAppointmentTest() {
		ClinicalRecordAppointment clinicalRecordAppointment = setupAppointment();
		clinicalRecordAppointment = dataAccessObject
				.createObject(clinicalRecordAppointment);
		int id = clinicalRecordAppointment.getId();
		Assert.assertEquals(clinicalRecordAppointment, dataAccessObject
				.getObjectById(id, ClinicalRecordAppointment.class));
		Assert.assertEquals(
				"String",
				dataAccessObject.getObjectById(id,
						ClinicalRecordAppointment.class).getVeterinarian());
		clinicalRecordAppointment.setVeterinarian("UpdatedVeterinarian");
		clinicalRecordAppointmentService.updateClinicalRecordAppointment(id,
				clinicalRecordAppointment);
		Assert.assertEquals("UpdatedVeterinarian", dataAccessObject
				.getObjectById(id, ClinicalRecordAppointment.class)
				.getVeterinarian());
	}

	@Test
	public void deleteClinicalRecordAppointmentTest() {
		ClinicalRecordAppointment clinicalRecordAppointment = setupAppointment();
		clinicalRecordAppointment = dataAccessObject
				.createObject(clinicalRecordAppointment);
		int id = clinicalRecordAppointment.getId();
		Assert.assertEquals(clinicalRecordAppointment, dataAccessObject
				.getObjectById(id, ClinicalRecordAppointment.class));

		clinicalRecordAppointmentService.deleteClinicalRecordById(id);

		Assert.assertEquals(null, dataAccessObject.getObjectById(id,
				ClinicalRecordAppointment.class));
	}

	@Test
	public void getClinicalRecordAppointmentById() {

		ClinicalRecordAppointment firstRecord = setupAppointment();
		firstRecord = dataAccessObject.createObject(firstRecord);
		int firstId = firstRecord.getId();

		ClinicalRecordAppointment secondRecord = setupAppointment();
		secondRecord = dataAccessObject.createObject(secondRecord);
		int secondId = secondRecord.getId();

		Assert.assertEquals(firstRecord,
				clinicalRecordAppointmentService.getClinicalRecordById(firstId));
		Assert.assertEquals(secondRecord, clinicalRecordAppointmentService
				.getClinicalRecordById(secondId));

	}

}
