package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;

import br.com.bovdog.bean.Owner;

import org.apache.log4j.Logger;
//create class Owner DAO for database communication.
public class OwnerDAO {
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(OwnerDAO.class);

	private EntityManager entityManager = null;

	public OwnerDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
		logger.debug("Constructor method with entity manager object = " + factory);
	}

	// Find the owner in database using his id.
	public Owner getOwnerById(int id){
	    Owner owner = entityManager.find(Owner.class, id);
	    logger.debug("getOwnerById method with id "+ id +" and object owner = " + owner);
	    return owner;
	}

	// Create owner in database.
	public Owner createOwner(Owner owner){
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(owner);
		    entityManager.flush();
      
		    logger.debug("createOwner method with object owner = " + owner);
		    entityManager.getTransaction().commit();			

		} catch(Exception exception) {
			exception.printStackTrace();
			logger.fatal("catch statement on createOwner with exception = " + exception);
			entityManager.getTransaction().rollback();
		}
		return owner;
	}

	// Update owner in database.
	public void updateOwner(Owner owner){
		try{
			entityManager.getTransaction().begin();
		    entityManager.merge(owner);
		    logger.debug("updateOwner method with object owner = " + owner);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
			logger.fatal("catch statement on updateOwner with exception = " + exception);
			entityManager.getTransaction().rollback();
		}
	}

	// Delete owner in database using his id.
	public void deleteOwner(int id){
	    Owner owner = getOwnerById(id);
	    try {
	      entityManager.getTransaction().begin();
	      logger.debug("deleteOwner with id ("+ id +") method with object owner = " + owner);
	      entityManager.remove(owner);
	      entityManager.getTransaction().commit();
	    } catch(Exception exception) {
	      exception.printStackTrace();
	      logger.fatal("catch statement on deleteOwner with exception = " + exception);
	      entityManager.getTransaction().rollback();
	    }
	}

	// Return all owners that exist in database
	public List<Owner> getAllOwners(MultivaluedMap<String, String> queryParameters) {
	    List<Owner> owners = new ArrayList<Owner>();
	    List<Predicate> criteria = new ArrayList<Predicate>();
	    
	    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Owner> query = criteriaBuilder.createQuery(Owner.class);
	    Root<Owner> range = query.from(Owner.class);
	    
	    String sort = null;
	    String order = null;
	    
	    if(queryParameters.containsKey("_sort")) {
	    	sort = queryParameters.getFirst("_sort");
	    } else {
	    	sort = "id";
	    }
	    if(queryParameters.containsKey("_order")) {
	    	order = queryParameters.getFirst("_order");
	    } else {
	    	order = "asc";
	    }
	    
	    for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()){
	    	if (entry.getKey().charAt(0) != '_') {
				ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class, entry.getKey()); 
				criteria.add(criteriaBuilder.like(range.get(parameter.getName()), parameter));
			}
	    }
	    query.select(range);
	    if (criteria.size() > 0) {
    		query.where(criteria.toArray(new Predicate[0]));
	    }
	    if (order.equalsIgnoreCase("desc")) {
	    	query.orderBy(criteriaBuilder.desc(range.get(sort)));
	    } else {
	    	query.orderBy(criteriaBuilder.asc(range.get(sort)));
	    }
	    TypedQuery<Owner> typedQuery = entityManager.createQuery(query);
	    for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()) {
	    	if (entry.getKey().charAt(0) != '_') {
	    		typedQuery.setParameter(entry.getKey(), "%"+entry.getValue().get(0)+"%");
	    	}
	    	
	    }
    	owners = typedQuery.getResultList();

	    return owners;
	}

}
