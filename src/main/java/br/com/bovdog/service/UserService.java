package br.com.bovdog.service;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
	
	@GET
	@Path("/")
	@Produces("applicaion/json")
	public List<User> getAllUsers(){
		UserDAO dao = new UserDAO();
		return dao.getAllUsers();
	}
	
	@POST
	@Path("/users/byusername")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public List<User> getUserByUserName(@FormParam(value = "insertedUserName") String insertedUserName){
		UserDAO dao = new UserDAO();
		return dao.getUserByUserName(insertedUserName);
	}
	
	@POST
	@Path("/")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public User createUser(@FormParam(value = "userFullName")String userFullName,
																@FormParam(value = "userName")String userName,
																@FormParam(value = "userPassword")String userPassword){

		User user = new User();
		user.setUserFullName(userFullName);
		user.setUserName(userName);
		user.setUserPassword(userPassword);	
		
		UserDAO dao = new UserDAO();
		dao.createUser(user);
		return user;
	}
	
	@PUT
	@Path("/{id: [0-9]+}")
	@Consumes("application/x-www-form-urlencoded")
	public void updateUser(@PathParam("id")int userId,
																@FormParam(value = "userFullName")String userFullName,
																@FormParam(value = "userName")String userName,
																@FormParam(value = "userPassword")String userPassword){

		User user = new User();
		user.setId(userId);
		user.setUserFullName(userFullName);
		user.setUserName(userName);
		user.setUserPassword(userPassword);	
		
		UserDAO dao = new UserDAO();
		dao.updateUser(user);
	}
	
	@DELETE
	@Path("/{id: [0-9]+}")
	public void deleteUser(@PathParam("id") int userId ){
		UserDAO dao = new UserDAO();
		dao.deleteUser(userId);
	}
}
