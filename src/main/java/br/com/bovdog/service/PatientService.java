package br.com.bovdog.service;

//import java.sql.Date;
//import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.Patient;
import br.com.bovdog.dao.PatientDAO;

// create Patient service 
@Path("/PatientService")
public class PatientService {
	
	// create method to get all patients registered 
	@GET
	@Path("/patients")
	@Produces("application/json")
	public List<Patient> getAllPatient() {
		PatientDAO dao = new PatientDAO();
		return dao.getAllPatients();
	}
	
	// create method to create a new patient 
	@POST
	@Path("/patients/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Patient createPatient(@FormParam(value = "patientName") String patientName,
							 	 @FormParam(value = "specie") String specie,
							 	 @FormParam(value = "breed") String breed,
							 	 @FormParam(value = "size") char size,
							 	 @FormParam(value = "gender") char gender,
//							 	 @FormParam(value = "birthday") Date birthday,
							 	 @FormParam(value = "coat") String coat) {
		
		Patient patient = new Patient();
		patient.setPatientName(patientName);
		patient.setSpecie(specie);
		patient.setBreed(breed);
		patient.setSize(size);
		patient.setGender(gender);
//		patient.setBirthday(birthday);
		patient.setCoat(coat);
		
		PatientDAO dao = new PatientDAO();
		dao.createPatient(patient);
		return patient;
	}
	
	@POST
	@Path("/patients/getPatientById")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Patient getPatientById(@FormParam(value = "patientId") int patientId) {
		PatientDAO dao = new PatientDAO();
		return dao.getPatientById(patientId);
		
	}
	
	@POST
	@Path("/patients/updatePatient")
	@Consumes("application/x-www-form-urlencoded")
	public void updatePatient(@FormParam(value = "patientId") int patientID,
							  @FormParam(value = "patientName") String patientName,
							  @FormParam(value = "specie") String specie,
							  @FormParam(value = "breed") String breed,
							  @FormParam(value = "size") char size,
							  @FormParam(value = "gender") char gender,
//		 	 				  @FormParam(value = "birthday") Date birthday,
							  @FormParam(value = "coat") String coat) {
		
		Patient patient = new Patient();
		patient.setPatientId(patientID);
		patient.setPatientName(patientName);
		patient.setSpecie(specie);
		patient.setBreed(breed);
		patient.setSize(size);
		patient.setGender(gender);
//		patient.setBirthday(birthday);
		patient.setCoat(coat);
		
		PatientDAO dao = new PatientDAO();
		dao.updatePatient(patient);
	}
	
	// create method to delete one patient
	@DELETE
	@Path("/patients/{patientId:[0-9]+}/delete")
	public void deletePatient(@PathParam("patientId") int patientId) {
		PatientDAO dao = new PatientDAO();
		dao.deletePatient(patientId);
	}
	
}
