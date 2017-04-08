package br.com.bovdog.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.List;

import br.com.bovdog.dao.ClinicalRecordDAO;
import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.bean.ClinicalRecordVaccination;

@Path("/ClinicalRecordService")
public class ClinicalRecordService {

    @POST
    @Path("/getById")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public ClinicalRecord getClinicalRecordById(@FormParam("id") int id) {
        ClinicalRecordDAO dao = new ClinicalRecordDAO();
        return dao.getClinicalRecordById(id);
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public List<ClinicalRecord> getAllClinicalRecords() {
        ClinicalRecordDAO dao = new ClinicalRecordDAO();
        return dao.getAllClinicalRecords();
    }

    @POST
    @Path("/delete")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public List<ClinicalRecord> deleteClinicalRecordById(@FormParam("id") int id) {
        ClinicalRecordDAO dao = new ClinicalRecordDAO();
        dao.deleteClinicalRecord(id);
        return dao.getAllClinicalRecords();
    }

    @POST
    @Path("/{type:vaccination|appointment}/{method:create|update}")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public List<ClinicalRecord> createOrUpdateClinicalRecord(
            @FormParam("clinicalRecordId") int clinicalRecordId,
            @FormParam("anamnesis") String anamnesis,
            @FormParam("veterinarian") String veterinarian,
            @FormParam("clinicalHistory") String clinicalHistory,
            @FormParam("diagnosis") String diagnosis,
            @FormParam("patientTemperature") float patientTemperature,
            @FormParam("capillaryFill") float capillaryFill,
            @FormParam("patientPulse") String patientPulse,
            @FormParam("mucosasApparent") String mucosasApparent,
            @FormParam("patientRespiratoryRate") float patientRespiratoryRate,
            @FormParam("patientHeartRate") float patientHeartRate,
            @FormParam("patientWeight") float patientWeight,
            @PathParam("method") String method,
            @PathParam("type") String type
            ) {
    	
    	
    	ClinicalRecord record = null;
    	
    	if(type.equalsIgnoreCase("vaccination")) {
    		
    		record = new ClinicalRecordVaccination();
    		
    	} 
    	
    	if(type.equalsIgnoreCase("appointment")) {
    		
    		record = new ClinicalRecordAppointment();
    		
    	}

        ClinicalRecordDAO dao = new ClinicalRecordDAO();
        record.setAnamnesis(anamnesis);
        record.setVeterinarian(veterinarian);
        record.setClinicalHistory(clinicalHistory);
        record.setDiagnosis(diagnosis);
        record.setPatientTemperature(patientTemperature);
        record.setCapillaryFill(capillaryFill);
        record.setPatientPulse(patientPulse);
        record.setMucosasApparent(mucosasApparent);
        record.setPatientRespiratoryRate(patientRespiratoryRate);
        record.setPatientHeartRate(patientHeartRate);
        record.setPatientWeight(patientWeight);


        /*if (method.equalsIgnoreCase("update")) {
            record.setClinicalRecordId(clinicalRecordId);
            dao.updateClinicalRecord(record);    
        } else {
            if (method.equalsIgnoreCase("create")) {
                dao.createClinicalRecord(record);    
            }
        }*/

        return dao.getAllClinicalRecords();
            }

    public void createClinicalRecordVaccination(ClinicalRecordVaccination record) {
        ClinicalRecordDAO dao = new ClinicalRecordDAO();
        dao.createClinicalRecord(record);
    }
}
