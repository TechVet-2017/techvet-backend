package br.com.bovdog.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.dao.DataAccessObject;

@Path("/appointmentRecords")
public class ClinicalRecordAppointmentService implements ServiceInterface {
	
	private DataAccessObject dao;
	
	public ClinicalRecordAppointmentService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	
	public ClinicalRecordAppointmentService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	// Creating function to get all clinical records by id
	@GET
	@Path("/")
	@Produces("application/json")
	public List<ClinicalRecordAppointment> getAllClinicalRecords(@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		return dao.getAllObjects(queryParameters, ClinicalRecordAppointment.class);
	}

	// Creating clinical record service class
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public ClinicalRecord getClinicalRecordById(@PathParam("id") int id) { // Getting the clinical record DAO by it's id
		return dao.getObjectById(id, ClinicalRecordAppointment.class);
	}

	// Creating method to create a new clinical record for appointment
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public ClinicalRecord createClinicalRecordAppointment(ClinicalRecordAppointment request){
		request = (ClinicalRecordAppointment)dao.createObject(request);
	
		return dao.getObjectById(request.getId(), ClinicalRecordAppointment.class);
	}
	
	// Creating method to update a clinical record for appointment
	@PUT
	@Path("/{id: [0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public ClinicalRecord updateClinicalRecordAppointment(@PathParam("id") int id, ClinicalRecordAppointment request) {
		request.setId(id);
		dao.updateObject(request);
		return dao.getObjectById(id, ClinicalRecordAppointment.class);
	}

	// Creating method to delete a clinical record for appointment
	@DELETE
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public List<ClinicalRecordAppointment> deleteClinicalRecordById(@PathParam("id") int id) { //Deleting the clinical record DAO by it's id
		dao.deleteObject(id, ClinicalRecordAppointment.class);
		return dao.getAllObjects(null, ClinicalRecordAppointment.class);
	}
}	
