package br.com.bovdog.dao;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import br.com.bovdog.bean.Owner;
import br.com.bovdog.bean.Patient;
import br.com.bovdog.helper.PersistenceHelper;
import br.com.bovdog.service.PatientService;

public class PatientServiceTest {

	private Patient patient;
	private final String TEST_UNIT = "test-unit";
	private PatientService patientService;
	private DataAccessObject testDao;

	@Before
	public void setup() {
		patient = setupPatient();
		testDao = new DataAccessObject(TEST_UNIT);
		patientService = new PatientService(testDao);
	}

	@After
	public void clearDatabase() {
		PersistenceHelper.clearDatabase();
	}

	public Patient setupPatient() {
		Patient patient = new Patient();

		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatador.parse("15/09/1994");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		patient.setPatientName("Name");
		patient.setSpecies("Species");
		patient.setBreed("breed");
		patient.setSize("size");
		patient.setGender("gender");
		patient.setBirthday(date);
		patient.setCoat("Coat");
		patient.setPatientOwnerId(1);

		return patient;
	}

	@Test
	public void createPatientTest() {
		int id = patientService.createPatient(patient).getId();
		assertEquals(patient, testDao.getObjectById(id, Patient.class));
	}

	@Test
	public void listAllPatientsWithoutQueriesTest() {
		UriInfo ui = mock(UriInfo.class);
		when(ui.getQueryParameters()).thenReturn(null);
		List<Patient> patients = new ArrayList<Patient>();
		for (int i = 0; i < 3; i++) {
			Patient patient = setupPatient();
			patient.setPatientName("Patient " + i);
			patient = testDao.createObject(patient);
			patients.add(patient);
		}
		assertEquals(patients, patientService.getAllPatients(ui));
	}

	@Test
	public void listAllPatientsWithSortAndOrderQueries() {
		UriInfo ui = mock(UriInfo.class);
		@SuppressWarnings("unchecked")
		MultivaluedMap<String, String> queryParameters = mock(MultivaluedMap.class);
		when(queryParameters.containsKey("_sort")).thenReturn(true);
		when(queryParameters.containsKey("_order")).thenReturn(true);
		when(queryParameters.getFirst("_sort")).thenReturn("patientName");
		when(queryParameters.getFirst("_order")).thenReturn("desc");
		when(ui.getQueryParameters()).thenReturn(queryParameters);
		List<Patient> patients = new ArrayList<Patient>();
		for (int i = 0; i < 3; i++) {
			Patient patient = setupPatient();
			patient.setPatientName("Patient " + i);
			patient = testDao.createObject(patient);
			patients.add(patient);
		}
		assertEquals(patients.get(0).getPatientName(), patientService
				.getAllPatients(ui).get(2).getPatientName());
	}

	@Test
	public void updatePatientTest() {
		Patient patient = setupPatient();
		patient = patientService.createPatient(patient);

		assertEquals(testDao.getObjectById(patient.getId(), Patient.class)
				.getPatientName(), "Name");

		patient.setPatientName("NameUpdate");
		patient = patientService.updatePatient(patient.getId(), patient);

		assertEquals(testDao.getObjectById(patient.getId(), Patient.class)
				.getPatientName(), "NameUpdate");
		
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatador.parse("15/09/1994");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		assertEquals(testDao.getObjectById(patient.getId(), Patient.class)
				.getBirthday(), date);
		
		try {
			date = formatador.parse("20/09/2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		patient.setBirthday(date);
		patient = patientService.updatePatient(patient.getId(), patient);

		assertEquals(testDao.getObjectById(patient.getId(), Patient.class)
				.getBirthday(), date);
	}
	
	@Test
	public void deletePatientTest(){
	 	List<Patient> patients = new ArrayList<Patient>();
	 	for (int i = 0; i < 3; i++) {
	 		Patient patient = setupPatient();
	 		patient.setPatientName("Patient " + i);
	 		patient = testDao.createObject(patient);
	 		patients.add(patient);
	 	}
	 	 
	 	patientService.deletePatient(patients.get(0).getId());
	 	 
	 	assertEquals(patients.size()-1, testDao.getAllObjects(null, Patient.class).size());
	 }
	 @Test
	 public void getPatientOwnerId(){
		int patientOwnerId = patientService.createPatient(patient).getPatientOwnerId();
		assertEquals(patientOwnerId, patient.getPatientOwnerId());
	 }
	 @Test
	 public void getPatientById() {

		Patient firstPatient = setupPatient();
		firstPatient = testDao.createObject(firstPatient);
		int firstId = firstPatient.getId();

		Patient secondPatient = setupPatient();
		secondPatient = testDao.createObject(secondPatient);
		int secondId = secondPatient.getId();

		Assert.assertEquals(firstPatient,
				patientService.getPatientById(firstId));
		Assert.assertEquals(secondPatient, patientService
				.getPatientById(secondId));
	 }
}
