package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.bean.Owner;
import br.com.bovdog.dao.BathGroomingDAO;
import br.com.bovdog.dao.OwnerDAO;


@Path("/BathGroomingService")
public class BathGroomingService {
	
	private BathGroomingDAO dao = null;
	
	// creating the data access object for the BathGrooming class.
	public BathGroomingService() {
		BathGroomingDAO dao = new BathGroomingDAO();
	}
	
	// creating the method to find a specific object.
	@POST
	@Path("/getById")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public BathGrooming getBathGroomingById(@FormParam("id") int id) {
		BathGroomingDAO dao = new BathGroomingDAO();
	    return dao.getBathGroomingById(id);
	}

	// creating the method to return all BathGroomings objects.
	@GET
	@Path("/getAll")
	@Produces("application/json")
	public List<BathGrooming> getAllBathGroomings() {
		BathGroomingDAO dao = new BathGroomingDAO();
	 	return dao.getAllBathGroomings();
	}
	
	// creating the method to delete a specific object.
	@POST
	@Path("/delete")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<BathGrooming> deleteBathGroomingById(@FormParam("id") int id) {
		BathGroomingDAO dao = new BathGroomingDAO();
		dao.deleteBathGrooming(id);
		return dao.getAllBathGroomings();
	}
	  
	// creating the method to update an object.
	@POST
	@Path("/update")
	@Consumes("application/x-www-form-urlencoded")
	public void updateBathGrooming(@FormParam(value = "idBathGrooming") int idBathGrooming ,
									@FormParam(value = "serviceBathGrooming") String serviceBathGrooming){
			
		BathGrooming bathGrooming = new BathGrooming();
		bathGrooming.setIdBathGrooming(idBathGrooming);
		bathGrooming.setServiceBathGrooming(serviceBathGrooming);
			
		BathGroomingDAO dao = new BathGroomingDAO();
		dao.updateBathGrooming(bathGrooming);
	}
	
}
