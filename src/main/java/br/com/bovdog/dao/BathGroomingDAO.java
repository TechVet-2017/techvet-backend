package br.com.bovdog.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import br.com.bovdog.bean.BathGrooming;

// create class BathGrooming DAO for database communication.
public class BathGroomingDAO {
	
	private EntityManager entityManager = null;

	final static Logger logger = Logger.getLogger(BathGroomingDAO.class);
	
	public BathGroomingDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
		logger.debug("Constructor method with entity manager object = " + factory);
	}
	
	// find the owner in database using his id.
	public BathGrooming getBathGroomingById(int id) {
	    BathGrooming bathGrooming = entityManager.find(BathGrooming.class, id);
	    logger.debug("getBathGroomingById method with id "+ id +" and object owner = " + bathGrooming);
	    return bathGrooming;
	  }
	
	public List<BathGrooming> getAllBathGroomings() {
	    List<BathGrooming> bathGroomings = new ArrayList<BathGrooming>();
	    bathGroomings = entityManager.createQuery("FROM " + BathGrooming.class.getName()).getResultList();
	    logger.debug("getAllBathGroomings method with object bathGrooming = " + bathGroomings);
	    return bathGroomings;
	  }
	// create method for creation of BathGooming in database.
	public void createBathGrooming(BathGrooming bathGrooming) {
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.persist(bathGrooming);
	      
	      logger.debug("createBatGrooming method with object bathGrooming = " + bathGrooming);
	      entityManager.getTransaction().commit();
	    } catch(Exception e) {
	      e.printStackTrace();
	      logger.fatal("catch statement on createBathGrooming with exception = " + e);
	      entityManager.getTransaction().rollback();
	    }
	  }
	
	// method for update BathGrooming service in database.
	public void updateBathGrooming(BathGrooming bathGrooming){
		try {
		      entityManager.getTransaction().begin();
		      entityManager.merge(bathGrooming);
		      logger.debug("updateBathGrooming method with object bathGrooming = " + bathGrooming);
		      entityManager.getTransaction().commit();
		    } catch(Exception e) {
		      e.printStackTrace();
		      logger.fatal("catch statement on updateBathGrooming with exception = " + e);
		      entityManager.getTransaction().rollback();
		    }
	}
	// method to delete a specific BathGrooming service.
	public void deleteBathGrooming(int id) {
	    BathGrooming bathGrooming = getBathGroomingById(id);
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.remove(bathGrooming);
	      logger.debug("deleteBathGrooming with id("+id+")method with object bathGrooming = " + bathGrooming);
	      entityManager.getTransaction().commit();
	    } catch(Exception e) {
	      e.printStackTrace();
	      logger.fatal("catch statement on deleteGrooming with exception = " + e);
	      entityManager.getTransaction().rollback();
	    }
	  }

	
}
