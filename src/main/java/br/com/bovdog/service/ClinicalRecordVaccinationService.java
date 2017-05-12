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

import br.com.bovdog.dao.DataAccessObject;
import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordVaccination;

@Path("/vaccinationRecords")
public class ClinicalRecordVaccinationService implements ServiceInterface { // Creating clinical record
												// service class

	private DataAccessObject dao;
	
	public ClinicalRecordVaccinationService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	public ClinicalRecordVaccinationService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<ClinicalRecordVaccination> getAllClinicalRecords(
			@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParameters = ui
				.getQueryParameters();
		return dao.getAllObjects(queryParameters,
				ClinicalRecordVaccination.class);
	}

	// Creating clinical record service class

	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public ClinicalRecord getClinicalRecordById(@PathParam("id") int id) { // Getting
																			// the
																			// clinical
																			// record
																			// DAO
																			// by
																			// it's
																			// id
		return dao.getObjectById(id, ClinicalRecordVaccination.class);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public ClinicalRecord createClinicalRecordVaccination(
			ClinicalRecordVaccination request) {
		request = dao.createObject(request);

		return dao.getObjectById(request.getId(),
				ClinicalRecordVaccination.class);
	}

	@PUT
	@Path("/{id: [0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public ClinicalRecord updateClinicalRecordVaccination(
			@PathParam("id") int id, ClinicalRecordVaccination request) {
		request.setId(id);
		dao.updateObject(request);
		return dao.getObjectById(id, ClinicalRecordVaccination.class);
	}

	@DELETE
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public List<ClinicalRecordVaccination> deleteClinicalRecordById(@PathParam("id") int id) { // Deleting
																	// the
																	// clinical
																	// record
																	// DAO by
																	// it's id
		dao.deleteObject(id, ClinicalRecordVaccination.class);
		return dao.getAllObjects(null, ClinicalRecordVaccination.class);
	}
}
