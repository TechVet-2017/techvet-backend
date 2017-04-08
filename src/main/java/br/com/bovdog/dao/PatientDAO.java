package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bovdog.bean.Patient;

// create class Patient DAO for database communication.
public class PatientDAO {
	
	private EntityManager entityManager = null;
	
	// create constructor for Patient DAO
	public PatientDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
	    this.entityManager = factory.createEntityManager();
		
	}
	
	// create method to create a new patient
	public void createPatient(Patient patient) {
		
		// treatment to persist new patient data in database 
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(patient);
			entityManager.getTransaction().commit();
			
		// return error if caught SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	// create method getAllPatients to return list of Patients.
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		patients = entityManager.createQuery("FROM " + Patient.class.getName()).getResultList();
		return patients;
	}
	
}
