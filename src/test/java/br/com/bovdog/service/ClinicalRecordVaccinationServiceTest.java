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

import org.junit.Test;
import org.mockito.Mockito;

import br.com.bovdog.bean.ClinicalRecordVaccination;
import br.com.bovdog.bean.VaccinationFactory;
import br.com.bovdog.dao.DataAccessObject;

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
}
