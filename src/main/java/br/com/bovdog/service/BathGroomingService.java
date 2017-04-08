package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.dao.BathGroomingDAO;


@Path("/BathGroomingService")
public class BathGroomingService {
	
	private BathGroomingDAO dao = null;

	public BathGroomingService() {
		BathGroomingDAO dao = new BathGroomingDAO();
	}
	
	@POST
	@Path("/getById")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public BathGrooming getBathGroomingById(@FormParam("id") int id) {
		BathGroomingDAO dao = new BathGroomingDAO();
	    return dao.getBathGroomingById(id);
	}

	  @GET
	  @Path("/getAll")
	  @Produces("application/json")
	  public List<BathGrooming> getAllBathGroomings() {
	    BathGroomingDAO dao = new BathGroomingDAO();
	    return dao.getAllBathGroomings();
	  }
	
	  @POST
	  @Path("/delete")
	  @Consumes("application/x-www-form-urlencoded")
	  @Produces("application/json")
	  public List<BathGrooming> deleteBathGroomingById(@FormParam("id") int id) {
	    BathGroomingDAO dao = new BathGroomingDAO();
	    dao.deleteBathGrooming(id);
	    return dao.getAllBathGroomings();
	  }
	
	
}
