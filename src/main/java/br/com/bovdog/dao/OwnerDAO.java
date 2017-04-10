package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bovdog.bean.ClinicalRecord;
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
	public void createOwner(Owner owner){
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(owner);
      
		    logger.debug("createOwner method with object owner = " + owner);
		    entityManager.getTransaction().commit();			

		} catch(Exception exception) {
			exception.printStackTrace();
			logger.fatal("catch statement on createOwner with exception = " + exception);
			entityManager.getTransaction().rollback();
		}
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

	// Find owner using his cpf.
	public List<Owner> findOwnerByCpf(String insertedCpf){
	    List<Owner> owners = entityManager.createQuery("SELECT t FROM Owner t WHERE t.cpf LIKE :cpf")
	    		.setParameter("cpf", "%"+insertedCpf+"%").getResultList();
	    logger.debug("findOwnerByCpf method with cpf = ("+ insertedCpf +") and object owners = " + owners);
		return owners;	
	}	
	
	// Find owner using his name.
	public List<Owner> findOwnerByName(String insertedName){
	    List<Owner> owners = entityManager.createQuery("SELECT t FROM Owner t WHERE t.ownerName LIKE :name")
	    		.setParameter("name","%"+insertedName+"%").getResultList();

	    logger.debug("findOwnerByName method with name = ("+ insertedName +") and object owners = " + owners);
		return owners;	
	}	

	// Find owner using his phone number.
	public List<Owner> findOwnerByPhoneNumber(String insertedPhoneNumber){
	    List<Owner> owners = entityManager.createQuery("SELECT t FROM Owner t WHERE t.phoneNumber LIKE :phone")
	    		.setParameter("phone", "%"+insertedPhoneNumber+"%").getResultList();

	    logger.debug("findOwnerByPhoneNumber method with phone = ("+ insertedPhoneNumber +") and object owners = " + owners);
		return owners;	
	}

	// Return all owners that exist in database
	public List<Owner> getAllOwners(){
	    List<Owner> owners = new ArrayList<Owner>();
	    owners = entityManager.createQuery("FROM " + Owner.class.getName()).getResultList();
	    logger.debug("getAllOwners method with and object owners = " + owners);
	    return owners;
	}

}
