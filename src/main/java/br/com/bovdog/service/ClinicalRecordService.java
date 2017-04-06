package br.com.bovdog.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import br.com.bovdog.dao.ClinicalRecordDAO;
import br.com.bovdog.bean.ClinicalRecord;

@Path("/ClinicalRecordService")
public class ClinicalRecordService {

  @GET
  @Path("/getById")
  @Produces("application/json")
  public ClinicalRecord getClinicalRecordById() {
    ClinicalRecordDAO dao = new ClinicalRecordDAO();
    return dao.getClinicalRecordById();
  }

}
