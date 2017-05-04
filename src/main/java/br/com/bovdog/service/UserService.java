package br.com.bovdog.service;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import br.com.bovdog.bean.User;
import br.com.bovdog.dao.UserDAO;

@Path("/users")

public class UserService {
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<User> getAllUsers(){ // Listing all the DAO users
		UserDAO dao = new UserDAO();
		logger.debug("GET /users calling dao object = " + dao);
		return dao.getAllUsers();
	}
	
	@GET
	@Path("/{id: [0-9]+}")
	@Produces("application/json")
	public User getUserById(@PathParam("id") int id) { // Finding a DAO users by his id
		UserDAO dao = new UserDAO();
		return dao.getUserById(id);
	}
	
	@POST
	@Path("/findbyusername")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<User> findUserByUserName(@FormParam(value = "insertedUserName") String insertedUserName){ // Finding user DAO by his username
		UserDAO dao = new UserDAO();
		logger.debug("POST /users/findbyusername with name ("+ insertedUserName +")calling dao object = " + dao);
		return dao.findUserByUserName(insertedUserName);
	}
	
	@POST
	@Path("/findbyuserfullname")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<User> findUserByFullName(@FormParam(value = "insertedFullName") String insertedFullName){ // Finding user DAO by his full name
		UserDAO dao = new UserDAO();
		logger.debug("POST /users/findbyfullname with name ("+ insertedFullName +")calling dao object = " + dao);
		return dao.findUserByFullName(insertedFullName);
	}

	// Creating a method to create a user with name, username and password
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public User createUser(User request){ 

		User user = new User();
		logger.debug("POST /users/create with userName = "+ request.getUserName());
		logger.debug("POST /users/create with userFullName = "+ request.getUserFullName());
		logger.debug("POST /users/create with userPassword = "+ request.getUserPassword());
		user.setUserName(request.getUserName());
		user.setUserFullName(request.getUserFullName());
		user.setUserPassword(request.getUserPassword());

		UserDAO dao = new UserDAO();
		dao.createUser(user);
		logger.debug("POST /users/create with dao object = "+ dao);
		logger.debug("POST /users/create with user object = "+ user);
		return user;
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
		UserDAO dao = new UserDAO();
		dao.updateUser(request);
		
		logger.debug("POST /users/update with dao object = "+ dao);
		return dao.getUserById(userID);
	}
	
	// Creating a method to delete a user
	@DELETE
	@Path("/{id: [0-9]+}")
	public List<User> deleteUser(@PathParam("id") int id ){
		UserDAO dao = new UserDAO();
		logger.debug("DELETE /users/delete with dao object = "+ dao);
		logger.debug("DELETE /users/delete with id object = "+ id);
		dao.deleteUser(id);
		return dao.getAllUsers();
	}
}
