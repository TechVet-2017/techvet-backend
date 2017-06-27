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
import static org.junit.Assert.*;

import org.apache.log4j.Logger;

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.dao.DataAccessObject;


/**
 * Service class that handles requests and json consumption.
 * 
 * @author adailson2, mateusvroriz, antoniocoj, SkiNgK, gustavo2795, iamferreirajp, leomeister, LucasAmoedo, luizguilherme5, 
 * oliveiraMarcelo, varleysilva
 *
 */
@Path("/bathAndGrooming")
public class BathGroomingService implements ServiceInterface {
	
	private DataAccessObject dao;
	
	/**
	 * Constructs the BathGroomingService and initializes a dao object.
	 */
	private BathGroomingService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	
	/**
	 * Constructs and initializes the BathGroomingService with a dao object.
	 * 
	 * @param dao
	 */
	public BathGroomingService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(DataAccessObject.class);
	
	/**
	 * Creates a Bath and Grooming instance.
	 * 
	 * @param request
	 * @return request
	 */
	@POST
	@Path("/")
	@Produces("application/json")
	public BathGrooming createBathGrooming(BathGrooming request){
		
		dao.createObject(request);
		logger.debug("POST /bathAndGrooming/create with serviceBathGrooming = "+ request.getServiceBathGrooming());
		
		return request;
	}
	
	/**
	 * Finds a specific instance of Bath and Grooming by its ID.
	 * 
	 * @param id
	 * @return BathGrooming
	 */
	@GET
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public BathGrooming getBathGroomingById(@PathParam("id") int id) {
		assertNotNull(id);
		assert(id>0);
		BathGrooming desiredBathGrooming = null;
		desiredBathGrooming = dao.getObjectById(id, BathGrooming.class);
	    	
		assertNotNull(desiredBathGrooming);
		
		return desiredBathGrooming;
	}

	/**
	 * Returns all Bath and Grooming instances on a list.
	 * @param ui
	 * @return List<BathGrooming>
	 */
	@GET
	@Path("/")
	@Produces("application/json")
	public List<BathGrooming> getAllBathGroomings(@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /bathAndGrooming calling dao object = " + dao);
		List<BathGrooming> bathGroomingList = null;
		bathGroomingList = dao.getAllObjects(queryParameters, BathGrooming.class);
	 	return bathGroomingList;
	}
	
	/**
	 * Deletes a specific instance of Bath and Grooming by its ID.
	 * 
	 * @param id
	 * @return List<BathGrooming>
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<BathGrooming> deleteBathGroomingById(@PathParam("id") int id) {
		logger.debug("DELETE /bathAndGrooming/delete with dao object = "+ dao);
		logger.debug("DELETE /bathAndGrooming/delete with id object = "+ id);
		dao.deleteObject(id, BathGrooming.class);
		List<BathGrooming> bathGroomingNewList = null;
		bathGroomingNewList = dao.getAllObjects(null, BathGrooming.class);
		return bathGroomingNewList;
	}
	  
	/**
	 * Updates a specific Bath and Grooming instance by its ID.
	 * 
	 * @param BathGroomingId
	 * @param request
	 * @return BathGrooming
	 */
	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	public BathGrooming updateBathGrooming(@PathParam("id") int BathGroomingId, BathGrooming request){
			
		request.setId(BathGroomingId);
		logger.debug("POST /bathAndGrooming/update with id = "+ request.getId());
		logger.debug("POST /bathAndGrooming/update with ownerName = "+ request.getServiceBathGrooming());
		
		dao.updateObject(request);
		
		BathGrooming updatedBathGrooming = null;
		updatedBathGrooming = dao.getObjectById(BathGroomingId, BathGrooming.class);
		return updatedBathGrooming;
	}
	
}
