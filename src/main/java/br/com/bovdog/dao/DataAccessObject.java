package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.MultivaluedMap;

public class DataAccessObject {
	private DataAccessObject instance;
	private EntityManager entityManager = null;

	public DataAccessObject(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
	}
	
	// singleton pattern for Data Access Object
	protected <T> T getObjectById(int id, Class<T> bean){
	    T beanInstance = entityManager.find(bean, id);
	    return beanInstance;
	}

	// create getInstance method to create a new instance of DAO if it's null 
	public DataAccessObject getInstance() {
		if (instance == null) {
			instance = new DataAccessObject();
		} else {
			// nothing to do 
		}
		return instance;
	}
	
	public <T> T createObject (T beanInstance){
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(beanInstance);
		    entityManager.flush();
		    entityManager.getTransaction().commit();			

		} catch(Exception exception) {
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return beanInstance;
	}

	public <T> void updateObject(T beanInstance){
		try{
			entityManager.getTransaction().begin();
		    entityManager.merge(beanInstance);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public <T> void deleteObject(int id, Class<T> bean){
	    T beanInstance = getObjectById(id, bean);
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.remove(beanInstance);
	      entityManager.getTransaction().commit();
	    } catch(Exception exception) {
	      exception.printStackTrace();
	      entityManager.getTransaction().rollback();
	    }
	}
	
	public <T> List<T> getAllObjects(MultivaluedMap<String, String> queryParameters, Class<T> bean) {
	    List<T> objectList = new ArrayList<T>();
	    TypedQuery<T> typedQuery = QueryBuilder.buildQuery(queryParameters, entityManager, bean);
    	objectList = typedQuery.getResultList();

	    return objectList;
	}

}
