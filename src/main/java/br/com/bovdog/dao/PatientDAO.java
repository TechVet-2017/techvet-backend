package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import br.com.bovdog.bean.Owner;
import br.com.bovdog.bean.Patient;

// create class Patient DAO for database communication
public class PatientDAO {
	
	// Initializing the log service
	final static Logger logger = Logger.getLogger(PatientDAO.class);
	
	private EntityManager entityManager = null;
	
	// create constructor for Patient DAO
	public PatientDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
	    this.entityManager = factory.createEntityManager();
		logger.debug("Constructor method with entity manager object = " + factory);
	}
	
	// create method to create a new patient
	public void createPatient(Patient patient) {
		
		// treatment to persist new patient data in database 
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(patient);
			logger.debug("createPatient method with object patient = " + patient);
			entityManager.getTransaction().commit();
			
		// return error if caught SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("createPatient method with object patient = " + patient);
			entityManager.getTransaction().rollback();
		}
	}
	
	// create method getAllPatients to return list of Patients
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		patients = entityManager.createQuery("FROM " + Patient.class.getName()).getResultList();
		return patients;
	}
	
	// create method getPatientById to return a specific patient
	public Patient getPatientById(int id) {
		Patient patient = entityManager.find(Patient.class, id);
		logger.debug("getPatientById method with id " + id +"and object patient = " + patient);
		return patient;
	}
	
	// create method getPatientByName to return list of patients registered in database with same name
	public List<Patient> findPatientByName(String insertedName){
	    List<Patient> patients = entityManager.createQuery("SELECT t FROM Patient t WHERE t.patientName LIKE :name")
	    		.setParameter("name","%"+insertedName+"%").getResultList();
	    logger.debug("findPatientByName method with name = ("+ insertedName +") and object patients = " + patients);
		return patients;
	}
	
	public void updatePatient(Patient patient) {
		
		// treatment to update a patient
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(patient);
			logger.debug("updatePatient method with object patient = " + patient);
			entityManager.getTransaction().commit();
		
		// return error if caught SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("catch statement on updatePatienet with exception = " + e);
			entityManager.getTransaction().rollback();
		}
	}
	
	// create method to delete patient
	public void deletePatient(int patientId) {
		
		// search patient by id to remove that patient
		Patient patient = getPatientById(patientId);
		try {
			entityManager.getTransaction().begin();
			logger.debug("deletePatient with id ("+ patientId +") method with object patient = " + patient);
			entityManager.remove(patient);
			entityManager.getTransaction().commit();
		
		// return error if caught SQL exception
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("catch statement on deletePatient with exception  = " + e);
			entityManager.getTransaction().rollback();
		}
	}
}
