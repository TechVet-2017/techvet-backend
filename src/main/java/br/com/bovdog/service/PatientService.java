package br.com.bovdog.service;

//import java.sql.Date;
//import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.Owner;
import br.com.bovdog.bean.Patient;
import br.com.bovdog.dao.OwnerDAO;
import br.com.bovdog.dao.PatientDAO;

// create Patient service 
@Path("/patients")
public class PatientService {
	
	// create method to get all patients registered 
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Patient> getAllPatient() {
		PatientDAO dao = new PatientDAO();
		return dao.getAllPatients();
	}
	
	// create method to create a new patient 
	@POST
	@Path("/")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Patient createPatient(@FormParam("patientName") String patientName,
							 	 @FormParam("specie") String specie,
							 	 @FormParam("breed") String breed,
							 	 @FormParam("size") char size,
							 	 @FormParam("gender") char gender,
//							 	 @FormParam("birthday") Date birthday,
							 	 @FormParam("coat") String coat) {
		
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
	
	// create method to retrieve a patient by it's id from the database
	@GET
	@Path("/{id:[0-9]+}")
	@Produces("application/json")
	public Patient getPatientById(@PathParam("id") int patientId) {
		PatientDAO dao = new PatientDAO();
		return dao.getPatientById(patientId);
		
	}
	
	// create method to search patients by name 
	@POST
	@Path("/findbyname")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<Patient> findPatientByName(@FormParam(value = "insertedName") String insertedName){
		PatientDAO dao = new PatientDAO();
		return dao.findPatientByName(insertedName);
	}
	
	// create a method to update the information of an existing patient
	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/x-www-form-urlencoded")
	public void updatePatient(@PathParam("id") int patientID,
							  @FormParam("patientName") String patientName,
							  @FormParam("specie") String specie,
							  @FormParam("breed") String breed,
							  @FormParam("size") char size,
							  @FormParam("gender") char gender,
//		 	 				  @FormParam("birthday") Date birthday,
							  @FormParam("coat") String coat) {
		
		Patient patient = new Patient();
		patient.setId(patientID);
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
	@Path("/{id:[0-9]+}")
	public void deletePatient(@PathParam("id") int patientId) {
		PatientDAO dao = new PatientDAO();
		dao.deletePatient(patientId);
	}
	
}
