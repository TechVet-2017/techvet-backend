package br.com.bovdog.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.bovdog.bean.ClinicalRecordVaccination;
import br.com.bovdog.bean.VaccinationFactory;
import br.com.bovdog.dao.DataAccessObject;
import br.com.bovdog.helper.PersistenceHelper;

public class ClinicalRecordVaccinationServiceTest {
	DataAccessObject dataAcessObject = DataAccessObject.getInstance("test-unit");
	ClinicalRecordVaccinationService clinicalRecordVaccinationService = new ClinicalRecordVaccinationService(dataAcessObject);
	
	public ClinicalRecordVaccination setupVaccination() throws ParseException {
		
		VaccinationFactory vaccinationFactory = new VaccinationFactory();
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
		Date testDate = formatter.parse("01/01/2000");
		
		
		ClinicalRecordVaccination record = (ClinicalRecordVaccination) vaccinationFactory.createClinicalRecord();
		
		record.setVaccinationApplicationDate(testDate);
		record.setVaccinationLaboratory("String");
		record.setVaccinationName("String");
		record.setVaccinationReturnDate(testDate);
		record.setVermifugationApplicationDate(testDate);
		record.setVermifugationReturnDate(testDate);
		record.setVermifugeDosage("String");
		record.setVermifugeName("String");
		
		return record;
	}
	
	@After
	public void clearDatabase(){
		PersistenceHelper.clearDatabase();
	}
	
	@Test
	public void getAllClinicalRecordVaccinationTest() throws ParseException {
		
		UriInfo ui = Mockito.mock(UriInfo.class);
		@SuppressWarnings("unchecked")

		MultivaluedMap<String, String> queryParameters = Mockito.mock(MultivaluedMap.class);
		
		Mockito.when(ui.getQueryParameters()).thenReturn(queryParameters);
		
		clinicalRecordVaccinationService.getAllClinicalRecords(ui);
		
		List<ClinicalRecordVaccination> vaccinations = new ArrayList<ClinicalRecordVaccination>();
		
		for(int i = 0; i < 3; i++) {
			ClinicalRecordVaccination record = setupVaccination();
			record.setVaccinationLaboratory("String" + i);
			record = dataAcessObject.createObject(record);
			
			vaccinations.add(record);
		}
		Assert.assertEquals(vaccinations, dataAcessObject.getAllObjects(null, ClinicalRecordVaccination.class));	
	}
	
	@Test
	public void createClinicalReccordVaccinationTest() throws ParseException{
		ClinicalRecordVaccination clinicalRecordVaccination = setupVaccination();
		clinicalRecordVaccination = dataAcessObject.createObject(clinicalRecordVaccination);
		int id = clinicalRecordVaccination.getId();
		Assert.assertEquals(clinicalRecordVaccination, dataAcessObject.getObjectById(id, ClinicalRecordVaccination.class));
	}
	
	@Test
	public void updateClinicalRecordVaccinationTest() throws ParseException{
		ClinicalRecordVaccination clinicalRecordVaccination = setupVaccination();
		clinicalRecordVaccination = dataAcessObject.createObject(clinicalRecordVaccination);
		
		int id = clinicalRecordVaccination.getId();
		String vermifugeName = clinicalRecordVaccination.getVermifugeName();
	
		Assert.assertEquals(clinicalRecordVaccination, dataAcessObject.getObjectById(id, ClinicalRecordVaccination.class));
		Assert.assertEquals(vermifugeName, dataAcessObject.getObjectById(id, ClinicalRecordVaccination.class).getVermifugeName());
		
		String updatedVermifugeName = "UpdatedVermifugeName";
		
		clinicalRecordVaccination.setVermifugeName(updatedVermifugeName);
		
		dataAcessObject.updateObject(clinicalRecordVaccination);
		
		Assert.assertEquals(updatedVermifugeName, dataAcessObject.getObjectById(id, ClinicalRecordVaccination.class).getVermifugeName());
		
	}
}
