package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import br.com.bovdog.bean.ClinicalRecord;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.bean.ClinicalRecordVaccination;

// Create class record DAO for database communication.
public class ClinicalRecordDAO {

  private EntityManager entityManager = null;

  public ClinicalRecordDAO() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
    this.entityManager = factory.createEntityManager();

  }
	// Find the record in database using his id.
  public ClinicalRecord getClinicalRecordById(int id) {
    ClinicalRecord record = entityManager.find(ClinicalRecord.class, id);
    return record;
  }
	// Listing all the records in the database.
  public List<ClinicalRecordAppointment> getAllClinicalRecordsAppointment() {
    List<ClinicalRecordAppointment> records = new ArrayList<ClinicalRecordAppointment>();
    records = entityManager.createQuery("FROM " + ClinicalRecordAppointment.class.getName()).getResultList();
    return records;
  }
  
	//Listing all the records in the database.
  public List<ClinicalRecordVaccination> getAllClinicalRecordsVaccination() {
	 List<ClinicalRecordVaccination> records = new ArrayList<ClinicalRecordVaccination>();
	 records = entityManager.createQuery("FROM " + ClinicalRecordVaccination.class.getName()).getResultList();
	 return records;
  }
 
	// Create record in database.
  public ClinicalRecord createClinicalRecord(ClinicalRecord record) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(record);
      entityManager.flush();
      entityManager.getTransaction().commit();
    } catch(Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return record;
  }
	// Update record in database.
  public void updateClinicalRecord(ClinicalRecord record) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(record);
      entityManager.getTransaction().commit();
    } catch(Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }
	// Delete record in database using his id.
	public void deleteClinicalRecord(int id) {
    ClinicalRecord record = getClinicalRecordById(id);
    try {
      entityManager.getTransaction().begin();
      entityManager.remove(record);
      entityManager.getTransaction().commit();
    } catch(Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }

}
