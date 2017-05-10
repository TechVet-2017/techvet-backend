package br.com.bovdog.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import br.com.bovdog.bean.Owner;
import br.com.bovdog.dao.DataAccessObject;

import org.apache.log4j.Logger;

@Path("/owners")

public class OwnerService{
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(DataAccessObject.class);
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Owner> getAllOwners(@Context UriInfo ui) {
		DataAccessObject dao = DataAccessObject.getInstance();
		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /owners calling dao object = " + dao);
		return dao.getAllObjects(queryParameters, Owner.class);
	}
	
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public Owner getOwnerById(@PathParam("id") int id) {
		DataAccessObject dao = DataAccessObject.getInstance();
		return dao.getObjectById(id, Owner.class);
	}
	
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Owner createOwner(Owner request){

		DataAccessObject dao = DataAccessObject.getInstance();
		request = dao.createObject(request);
		logger.debug("POST /owners/create with dao object = "+ dao);
		logger.debug("POST /owners/create with owner object = "+ request);
		return request;
	}

	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	public Owner updateOwner(Owner request, @PathParam("id") int id){

		DataAccessObject dao = DataAccessObject.getInstance();
		request.setId(id);
		dao.updateObject(request);
		logger.debug("POST /owners/update with dao object = "+ dao);
		logger.debug("POST /owners/update with owner object = "+ request);
		return dao.getObjectById(request.getId(), Owner.class);

	}

	@DELETE
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public List<Owner> deleteOwner(@PathParam("id") int id ){
		DataAccessObject dao = DataAccessObject.getInstance();
		logger.debug("DELETE /owners/delete with dao object = "+ dao);
		logger.debug("DELETE /owners/delete with id object = "+ id);
		dao.deleteObject(id, Owner.class);
		return dao.getAllObjects(null, Owner.class);
	}


}
