package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import br.com.bovdog.bean.ClinicalRecord;

// Create class Owner DAO for database communication.
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
  public List<ClinicalRecord> getAllClinicalRecords() {
    List<ClinicalRecord> records = new ArrayList<ClinicalRecord>();
    records = entityManager.createQuery("FROM " + ClinicalRecord.class.getName()).getResultList();
    return records;
  }
	// Create record in database.
  public void createClinicalRecord(ClinicalRecord record) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(record);
      entityManager.getTransaction().commit();
    } catch(Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
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
