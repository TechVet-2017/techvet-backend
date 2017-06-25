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

import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.bean.User;
import br.com.bovdog.dao.DataAccessObject;

/**Class service of users, where they will be contained, requisitions, 
 * production and consumption of application json.
 * @author adailson2, antoniocoj, luizguilherme, leomeister, SkiNgK, iamferreirajp, varleysilva, gustavo2795, mateusvroriz	
 * @version 1.0
 */

@Path("/users")

public class UserService implements ServiceInterface {
	
	/**Declaration of generic dao
	 */
	private DataAccessObject dao;
	
	/**Initializing the log service
	 */
	final static Logger logger = Logger.getLogger(DataAccessObject.class);
	
	/**
	 * Constructor for a user service, containing dao object creation 
	 * @return User*/
	public UserService() {
		dao = DataAccessObject.getInstance(TECHVET_UNIT);
	}
	
	/**
	 * Constructor for a user service, containing dao object input 
	 * @param dao
	 * @return User*/
	public UserService(DataAccessObject dao) {
		this.dao = dao;
	}
	
	/**
	 * Method to return all users and make request get
	 * @param ui
	 * @return List<User> - userList*/
	@GET
	@Path("/")
	@Produces("application/json")
	public List<User> getAllUsers(@Context UriInfo ui){

		MultivaluedMap<String, String> queryParameters = ui.getQueryParameters();
		logger.debug("GET /users calling dao object = " + dao);
		List<User> userList = null;
		userList = dao.getAllObjects(queryParameters, User.class);
	 	return userList;
	}
	/**
	 * Method to return all users by id and make request get
	 * @param id
	 * @return User - allUsersId*/
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public User getUserById(@PathParam("id") int id) { // Finding a DAO users by his id
		User desiredUser = null;
		desiredUser = dao.getObjectById(id, User.class);
		return desiredUser;
	}
	
	/**
	 * Method to create the user with userName, userFullName and userPassword of User Bean.
	 * @param request (object of user)
	 * @return request*/
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
	
	/**
	 * Method to update the user with userName, userFullName and userPassword of User Bean.
	 * @param request (object of user)
	 * @return User - updateUser*/
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
	
	/**
	 * Method to delete the user with id param of User Bean.
	 * @param id
	 * @return userAllusers */
	@DELETE
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public List<User> deleteUser(@PathParam("id") int id ){

		logger.debug("DELETE /users/delete with dao object = "+ dao);
		logger.debug("DELETE /users/delete with id object = "+ id);
		dao.deleteObject(id, User.class);
		List<User> userNewList = null;
		userNewList = dao.getAllObjects(null, User.class);
		return userNewList;
	}
}
