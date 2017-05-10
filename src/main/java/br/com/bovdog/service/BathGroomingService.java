package br.com.bovdog.service;

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

import org.apache.log4j.Logger;

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.dao.DataAccessObject;


@Path("/bathAndGrooming")
public class BathGroomingService {
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(DataAccessObject.class);
	
	// creating the method to create BathGrooming object.
	@POST
	@Path("/")
	@Produces("application/json")
	public BathGrooming createBathGrooming(BathGrooming request){
		DataAccessObject dao = DataAccessObject.getInstance();
		
		dao.createObject(request);
		logger.debug("POST /bathAndGrooming/create with serviceBathGrooming = "+ request.getServiceBathGrooming());
		
		return request;
	}
	
	// creating the method to find a specific object.
	@GET
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public BathGrooming getBathGroomingById(@PathParam("id") int id) {
		DataAccessObject dao = DataAccessObject.getInstance();
	    return dao.getObjectById(id, BathGrooming.class);
	}

	// creating the method to return all BathGroomings objects.
	@GET
	@Path("/")
	@Produces("application/json")
	public List<BathGrooming> getAllBathGroomings(@Context UriInfo ui) {
		DataAccessObject dao = DataAccessObject.getInstance();
		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /bathAndGrooming calling dao object = " + dao);
	 	return dao.getAllObjects(queryParameters, BathGrooming.class);
	}
	
	// creating the method to delete a specific object.
	@DELETE
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<BathGrooming> deleteBathGroomingById(@PathParam("id") int id) {
		DataAccessObject dao = DataAccessObject.getInstance();
		logger.debug("DELETE /bathAndGrooming/delete with dao object = "+ dao);
		logger.debug("DELETE /bathAndGrooming/delete with id object = "+ id);
		dao.deleteObject(id, BathGrooming.class);
		return dao.getAllObjects(null, BathGrooming.class);
	}
	  
	// creating the method to update an object.
	@PUT
	@Path("//{id:[0-9]+}")
	@Consumes("application/json")
	public BathGrooming updateBathGrooming(BathGrooming request){
			
		BathGrooming bathGrooming = new BathGrooming();
		logger.debug("POST /bathAndGrooming/update with id = "+ request.getId());
		logger.debug("POST /bathAndGrooming/update with ownerName = "+ request.getServiceBathGrooming());
		bathGrooming.setId(request.getId());
		bathGrooming.setServiceBathGrooming(request.getServiceBathGrooming());
			
		DataAccessObject dao = DataAccessObject.getInstance();
		dao.updateObject(bathGrooming);
		
		return dao.getObjectById(request.getId(), BathGrooming.class);
	}
	
}
