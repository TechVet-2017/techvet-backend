package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.Patient;
import br.com.bovdog.dao.PatientDAO;

@Path("/PatientService")
public class PatientService {
	
	@GET
	@Path("/patients")
	@Produces("application/json")
	public List<Patient> getAllPatient() {
		PatientDAO dao = new PatientDAO();
		return dao.getAllPatients();
	}
}
