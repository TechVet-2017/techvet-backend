package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.Owner;

//create class Owner DAO for database communication.
public class OwnerDAO {
	
	private EntityManager entityManager = null;
	
	public OwnerDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
		this.entityManager = factory.createEntityManager();
	}

	// Find the owner in database using his id.
	public Owner getOwnerById(int id){
	    Owner owner = entityManager.find(Owner.class, id);
	    return owner;
	}
	
	// Create Owner in database.
	public void createOwner(Owner owner){
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(owner);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	// Update owner in database.
	public void updateOwner(Owner owner){
		try{
			entityManager.getTransaction().begin();
		    entityManager.persist(owner);
		    entityManager.getTransaction().commit();			
		} catch(Exception exception) {
			exception.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	// Delete owner in database using his id.
	public void deleteOwner(int id){
	    Owner owner = getOwnerById(id);
	    try {
	      entityManager.getTransaction().begin();
	      entityManager.remove(owner);
	      entityManager.getTransaction().commit();
	    } catch(Exception exception) {
	      exception.printStackTrace();
	      entityManager.getTransaction().rollback();
	    }
	}
	
	// Find owner using his cpf.
	public List<Owner> findOwnerByCpf(String insertedCpf){
	    List<Owner> owners = entityManager.createQuery("SELECT * FROM owner WHERE phoneNumber = :cpf")
	    		.setParameter("cpf", "insertedCpf").getResultList();
		return owners;	
	}	
	
	// Find owner using his name.
	public List<Owner> findOwnerByName(String insertedName){
	    List<Owner> owners = entityManager.createQuery("SELECT * FROM owner WHERE phoneNumber = :name")
	    		.setParameter("name", "insertedName").getResultList();
		return owners;	
	}	
	
	// Find owner using his phone number.
	public List<Owner> findOwnerByPhoneNumber(Long insertedPhoneNumber){
	    List<Owner> owners = entityManager.createQuery("SELECT * FROM owner WHERE phoneNumber = :phone")
	    		.setParameter("phone", "insertedPhoneNumber").getResultList();
		return owners;	
	}
	
	// Return all owners that exist in database
	public List<Owner> getAllOwners(){
	    List<Owner> owners = new ArrayList<Owner>();
	    owners = entityManager.createQuery("FROM " + Owner.class.getName()).getResultList();
	    return owners;
	}

}
