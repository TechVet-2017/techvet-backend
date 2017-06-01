package br.com.bovdog.service;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import br.com.bovdog.bean.User;
import br.com.bovdog.dao.DataAccessObject;

@Path("/users")

public class UserService implements ServiceInterface {
	
	private DataAccessObject dao = null;
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(DataAccessObject.class);
	
	public UserService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	
	public UserService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<User> getAllUsers(@Context UriInfo ui){ // Listing all the DAO users

		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /users calling dao object = " + dao);
		
		return dao.getAllObjects(queryParameters, User.class);
	}
	
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public User getUserById(@PathParam("id") int id) { // Finding a DAO users by his id

		return dao.getObjectById(id, User.class);
	}
	

	// Creating a method to create a user with name, username and password
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public User createUser(User request){ 

		logger.debug("POST /users/create with userName = "+ request.getUserName());
		logger.debug("POST /users/create with userFullName = "+ request.getUserFullName());
		logger.debug("POST /users/create with userPassword = "+ request.getUserPassword());

		request = dao.createObject(request);
		logger.debug("POST /users/create with dao object = "+ dao);
		logger.debug("POST /users/create with user object = "+ request);
		
		return request;
	}
	
	// create a method to update the information of an existing patient
	@PUT
	@Path("/{id:[0-9]+}")
	@Consumes("application/json")
	@Produces("application/json")
	public User updateUser(@PathParam("id") int userID, User request) {
		logger.debug("POST /users/update with userName = "+ request.getUserName());
		logger.debug("POST /users/update with userFullName = "+ request.getUserFullName());
		logger.debug("POST /users/update with userPassword = "+ request.getUserPassword());
		
		request.setId(userID);
		dao.updateObject(request);
		
		logger.debug("POST /users/update with dao object = "+ dao);
		
		return dao.getObjectById(userID, User.class);
	}
	
	// creating a method to delete a user
	@DELETE
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public List<User> deleteUser(@PathParam("id") int id ){

		logger.debug("DELETE /users/delete with dao object = "+ dao);
		logger.debug("DELETE /users/delete with id object = "+ id);
		dao.deleteObject(id, User.class);
		
		return dao.getAllObjects(null, User.class);
	}
}
