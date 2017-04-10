package br.com.bovdog.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bovdog.bean.BathGrooming;

// create class BathGrooming DAO for database communication.
public class BathGroomingDAO {
	
	private EntityManager entityManager = null;

	public BathGroomingDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
	    this.entityManager = factory.createEntityManager();
	}
	
	// find the owner in database using his id.
	public BathGrooming getBathGroomingById(int id) {
	    BathGrooming bathGrooming = entityManager.find(BathGrooming.class, id);
	    return bathGrooming;
	  }
	
	public List<BathGrooming> getAllBathGroomings() {
	    List<BathGrooming> bathGroomings = new ArrayList<BathGrooming>();
	    bathGroomings = entityManager.createQuery("FROM " + BathGrooming.class.getName()).getResultList();
	    return bathGroomings;
	  }
	// create method for creation of BathGooming in database.
	public void createBathGrooming(BathGrooming bathGrooming) {
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.persist(bathGrooming);
	      entityManager.getTransaction().commit();
	    } catch(Exception e) {
	      e.printStackTrace();
	      entityManager.getTransaction().rollback();
	    }
	  }
	
	// method for update BathGrooming service in database.
	public void updateBathGrooming(BathGrooming bathGrooming){
		try {
		      entityManager.getTransaction().begin();
		      entityManager.merge(bathGrooming);
		      entityManager.getTransaction().commit();
		    } catch(Exception e) {
		      e.printStackTrace();
		      entityManager.getTransaction().rollback();
		    }
	}
	// method to delete a specific BathGrooming service.
	public void deleteBathGrooming(int id) {
	    BathGrooming bathGrooming = getBathGroomingById(id);
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.remove(bathGrooming);
	      entityManager.getTransaction().commit();
	    } catch(Exception e) {
	      e.printStackTrace();
	      entityManager.getTransaction().rollback();
	    }
	  }

	
}
