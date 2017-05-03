package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import br.com.bovdog.bean.User;

// create class User DAO for database communication.
public class UserDAO {
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(PatientDAO.class);
		
	private EntityManager entityManager = null;
	
	public UserDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
	}
	
	// create method getUserById to return a specific user
	public User getUserById(int id) {
		User user = entityManager.find(User.class, id);
		logger.debug("getUserById method with id " + id +"and object user = " + user);
		return user;
	}

	// create method for creation of user in database.
	public void createUser(User user) {
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(user);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
		
	// method for update user in database.
	public void updateUser(User user) {	
		// treatment to update a user
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			logger.debug("updateUser method with object user = " + user);
			entityManager.getTransaction().commit();
		
		// return error if caught SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("catch statement on updatePatienet with exception = " + e);
			entityManager.getTransaction().rollback();
		}
	}
		
	// method to delete a specific user.
	public void deleteUser(int id) {
		 User user = getUserById(id);
		 try {
			 entityManager.getTransaction().begin();
		     entityManager.remove(user);
		     entityManager.getTransaction().commit();
		 } catch(Exception exception) {
		     exception.printStackTrace();
		     entityManager.getTransaction().rollback();
		    }
	}
	
	// create method to select all users from table by UserName.
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		users = entityManager.createQuery("FROM " + User.class.getName()).getResultList();
		    return users;
	}
	
	// create method to select a user from table by UserName.
	public List<User> findUserByUserName(String insertedUserName) {
		 List<User> users = entityManager.createQuery("SELECT t FROM User t WHERE t.userName LIKE :name")
		    		.setParameter("name","%"+insertedUserName+"%").getResultList();
			return users;	
	}
	
	// create method to select a user from table by UserName.
	public List<User> findUserByFullName(String insertedFullName) {
		 List<User> users = entityManager.createQuery("SELECT t FROM User t WHERE t.userFullName LIKE :fullname")
		    		.setParameter("fullname","%"+insertedFullName+"%").getResultList();
			return users;	
	}
	
}