package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;
import com.mysql.cj.api.log.Log;

/**
 * DAO promotes object data access with the database, 
 * the singleton pattern was used to instantiate it only once.
 * 
 * @author SkiNgK, adailson2, antoniocoj, luizguilherme, leomeister, SkiNgK, iamferreirajp, varleysilva,
 * gustavo2795, mateusvroriz
 * 
 * @version 1.0
 *
 */

public class DataAccessObject {
	
	/**
	 * Declarations for using in DataAcessObjects
	 */
	public static DataAccessObject instance;
	private EntityManager entityManager = null;
	private final String TECHVET_UNIT = "techvet-unit";
	private static final Logger logger = Logger.getLogger(DataAccessObject.class);

	/**
	 * This constructor performs the persistence of the data in the database
	 * @param persistenceUnit
	 * @return DataAcessObject
	 */
	protected DataAccessObject(String persistenceUnit) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(persistenceUnit);
		this.entityManager = factory.createEntityManager();
	}

	/**
	 * This constructor to create a new instance of DAO if it's null
	 * @param persistenceUnit
	 * @return instance of DataAcessObject
	 * 
	 */
	public static DataAccessObject getInstance(String persistenceUnit) {
		logger.info("Method DataAccessObject started.");
		if (instance == null) {
			instance = new DataAccessObject(persistenceUnit);
		} else {
			// nothing to do
		}
		assert(instance != null):("Null instance returned");
		return instance;
	}
	
	/**
	 * This method have generic type for get generic object by id
	 * @param id
	 * @param bean
	 * @return beanInstance
	 */
	public <T> T getObjectById(int id, Class<T> bean) {
		logger.info("Method getObjectById started.");
		T beanInstance = entityManager.find(bean, id);
		return beanInstance;
	}

	/**
	 * This method create object generic
	 * @param beanInstance
	 * @return beanInstance
	 */
	public <T> T createObject(T beanInstance) {
		logger.info("Method createObject started.");
		// Here the transaction is initiated, the instance persisted and transaction finished. 
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(beanInstance);
			entityManager.flush();
			entityManager.getTransaction().commit();

		} catch (Exception exception) {
			logger.error("Exception " + exception + "happened.");
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return beanInstance;
	}

	/**
	 * This method update object generic
	 * @param beanInstance
	 */
	public <T> void updateObject(T beanInstance) {
		logger.info("Method updateObject started.");
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(beanInstance);
			entityManager.getTransaction().commit();
		} catch (Exception exception) {
			logger.error("Exception " + exception + "happened.");
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/**
	 * This method delete object generic
	 * @param id
	 * @param bean
	 */
	public <T> void deleteObject(int id, Class<T> bean) {
		logger.info("Method deleteObject started.");
		T beanInstance = getObjectById(id, bean);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(beanInstance);
			entityManager.getTransaction().commit();
		} catch (Exception exception) {
			logger.error("Exception " + exception + "happened.");
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/**
	 * This method get all objects generic
	 * @param bean
	 * @return objectList
	 */
	public <T> List<T> getAllObjects(
			MultivaluedMap<String, String> queryParameters, Class<T> bean) {
		logger.info("Method getAllObjects started.");
		List<T> objectList = new ArrayList<T>();
		TypedQuery<T> typedQuery = QueryBuilder.buildQuery(queryParameters,
				entityManager, bean);
		objectList = typedQuery.getResultList();

		return objectList;
	}

}
