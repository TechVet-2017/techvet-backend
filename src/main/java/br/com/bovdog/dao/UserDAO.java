package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bovdog.bean.User;

// create class User DAO for database communication.
public class UserDAO {
	
	private EntityManager entityManager = null;
	
	public UserDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
	}
	
	// Find the owner in database using his id.
	public User getUserById(int id){
		User user = entityManager.find(User.class, id);
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
	public void updateUser(User user){
		try{
			entityManager.getTransaction().begin();
		    entityManager.merge(user);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
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
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		users = entityManager.createQuery("FROM " + User.class.getName()).getResultList();
		    return users;
	}
	
	// create method to select a user from table by UserName.
	public List<User> getUserByUserName(String insertedUserName) {
		 List<User> users = entityManager.createQuery("SELECT t FROM User t WHERE t.userName LIKE :name")
		    		.setParameter("name","%"+insertedUserName+"%").getResultList();
			return users;	
	}
	
}