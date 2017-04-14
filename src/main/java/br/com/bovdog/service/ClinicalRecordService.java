package br.com.bovdog.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.List;
import java.util.Date;

import br.com.bovdog.dao.ClinicalRecordDAO;
import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.bean.ClinicalRecordVaccination;

@Path("/clinicalRecord")
public class ClinicalRecordService { // Creating clinical record service class

	@POST
	@Path("/getById")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public ClinicalRecord getClinicalRecordById(@FormParam("id") int id) { // Getting the clinical record DAO by it's id
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		return dao.getClinicalRecordById(id);
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public List<ClinicalRecord> getAllClinicalRecords() {
		ClinicalRecordDAO dao = new ClinicalRecordDAO(); // Listing all the DAO clinical records
		return dao.getAllClinicalRecords();
	}

	@POST
	@Path("/delete")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<ClinicalRecord> deleteClinicalRecordById(@FormParam("id") int id) { //Deleting the clinical record DAO by it's id
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		dao.deleteClinicalRecord(id);
		return dao.getAllClinicalRecords();
	}


	/* TODO refactor */
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public List<ClinicalRecord> createClinicalRecordVaccination(ClinicalRecord 	request){
		ClinicalRecordDAO dao = new ClinicalRecordDAO();
		

		return dao.getAllClinicalRecords();
	}
}	
