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

import br.com.bovdog.bean.Patient;
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
	@Consumes("application/json")
	@Produces("application/json")
	public Patient createPatient(Patient request) {

		PatientDAO dao = new PatientDAO();
		dao.createPatient(request);
		return request;
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
	@Consumes("application/json")
	public Patient updatePatient(@PathParam("id") int patientID, Patient request) {
		
		request.setId(patientID);
		PatientDAO dao = new PatientDAO();
		dao.updatePatient(request);
		
		return dao.getPatientById(patientID);
	}
	
	// create method to delete one patient
	@DELETE
	@Path("/{id:[0-9]+}")
	public void deletePatient(@PathParam("id") int patientId) {
		PatientDAO dao = new PatientDAO();
		dao.deletePatient(patientId);
	}
	
}
