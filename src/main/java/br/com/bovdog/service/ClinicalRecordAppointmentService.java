package br.com.bovdog.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.List;

import br.com.bovdog.dao.ClinicalRecordDAO;
import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;

@Path("/appointmentRecords")
public class ClinicalRecordAppointmentService { 

	// Creating function to get all clinical records by id
	@GET
	@Path("/")
	@Produces("application/json")
	public List<ClinicalRecord> getAllClinicalRecords() {
		ClinicalRecordDAO dao = new ClinicalRecordDAO(); // Listing all the DAO clinical records
		return dao.getAllClinicalRecords();
	}

	// Creating clinical record service class
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public ClinicalRecord getClinicalRecordById(@PathParam("id") int id) { // Getting the clinical record DAO by it's id
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		return dao.getClinicalRecordById(id);
	}

	// Creating method to create a new clinical record for appointment
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public List<ClinicalRecord> createClinicalRecordAppointment(ClinicalRecordAppointment request){
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		dao.createClinicalRecord(request);
	
		return dao.getAllClinicalRecords();
	}
	
	// Creating method to update a clinical record for appointment
	@PUT
	@Path("/{id: [0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public ClinicalRecord updateClinicalRecordAppointment(@PathParam("id") int id, ClinicalRecordAppointment request) {
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		request.setId(id);
		dao.updateClinicalRecord(request);
		return dao.getClinicalRecordById(id);
	}

	// Creating method to delete a clinical record for appointment
	@DELETE
	@Path("/{id: [0-9]+}")
	public void deleteClinicalRecordById(@PathParam("id") int id) { //Deleting the clinical record DAO by it's id
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		dao.deleteClinicalRecord(id);
	}
}	
