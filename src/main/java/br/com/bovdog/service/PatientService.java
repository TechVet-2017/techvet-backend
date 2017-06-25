package br.com.bovdog.service;

//import java.sql.Date;
//import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import br.com.bovdog.bean.Patient;
import br.com.bovdog.dao.DataAccessObject;

import org.apache.log4j.Logger;

/**
 * Service class that handles requests and json consumption for Patients class.
 * 
 * @author SkiNgK, adailson2, antoniocoj, luizguilherme, leomeister, SkiNgK, iamferreirajp, varleysilva,
 * gustavo2795, mateusvroriz
 * 
 * @version 1.0
 *
 */
@Path("/patients")
public class PatientService implements ServiceInterface {
	
	private DataAccessObject dao;
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(DataAccessObject.class);

	/**
	 * Constructs the PatientService and initializes a dao object. 
	 */
	public PatientService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	
	/**
	 * Constructs and initializes the PatientService with a dao object.
	 * @param dao
	 */
	public PatientService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	/**
	 * Returns all instances of Patients on a list.
	 *  
	 * @param ui
	 * @return
	 */
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Patient> getAllPatients(@Context UriInfo ui) {

		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /patients calling dao object = " + dao);
		return dao.getAllObjects(queryParameters, Patient.class);
	}
	
	/**
	 * Creates a Patient instance.
	 *  
	 * @param request
	 * @return
	 */
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Patient createPatient(Patient request) {

		// create request object corresponding to patient copy object
		request = dao.createObject(request);
		logger.debug("POST /patients create patient name = " + request.getPatientName());
		logger.debug("POST /patients create patient size = " + request.getSize());
		logger.debug("POST /patients create patient gender = " + request.getGender());
		logger.debug("POST /patients create patient species = " + request.getSpecies());
		logger.debug("POST /patients create patient birthday = " + request.getBirthday());
		logger.debug("POST /patients create patient breed = " + request.getBreed());
		logger.debug("POST /patients create patient coat = " + request.getCoat());
		logger.debug("POST /patients create patient id = " + request.getId());
		
		// return created request
		return dao.getObjectById(request.getId(), Patient.class);
	}
	
	/**
	 * Find a specific instance of Patient by its ID.
	 * 
	 * @param patientId
	 * @return
	 */
	@GET
	@Path("/{id:[0-9]+}")
	@Produces("application/json")
	public Patient getPatientById(@PathParam("id") int patientId) {

		logger.debug("GET /patients/("+ patientId +") find patient by id = " + dao);
		
		return dao.getObjectById(patientId, Patient.class);
		
	}
	
	/**
	 * Updates the instance of Patient by its ID.
	 * 
	 * @param patientID
	 * @param request
	 * @return
	 */
	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	public Patient updatePatient(@PathParam("id") int patientID, Patient request) {
		
		request.setId(patientID);
		dao.updateObject(request);
		logger.debug("PUT /patients/("+ patientID +") update patient by id = " + dao);
		
		return dao.getObjectById(patientID, Patient.class);
	}
	
	/**
	 * Deletes a specific instance of Patient by its ID.
	 * 
	 * @param patientId
	 * @return
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	@Produces("application/json")
	public List<Patient> deletePatient(@PathParam("id") int patientId) {

		logger.debug("DELETE /patients/("+ patientId +") with dao object = "+ dao);
		logger.debug("DELETE /patients/("+ patientId +") with id object = "+ patientId);
		dao.deleteObject(patientId, Patient.class);
		
		return dao.getAllObjects(null, Patient.class);
	}
	
}
