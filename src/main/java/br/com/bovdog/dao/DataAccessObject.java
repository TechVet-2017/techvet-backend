package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.MultivaluedMap;

public class DataAccessObject {
	
	private EntityManager entityManager = null;
	private final String TECHVET_UNIT = "techvet-unit";

	public DataAccessObject(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(TECHVET_UNIT);
		this.entityManager = factory.createEntityManager();
	}
	
	public DataAccessObject(String persistenceUnit) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);
		this.entityManager = factory.createEntityManager();
	}
			
	
	public <T> T getObjectById(int id, Class<T> bean){
	    T beanInstance = entityManager.find(bean, id);
	    return beanInstance;
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
