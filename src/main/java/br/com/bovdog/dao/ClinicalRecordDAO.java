package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import br.com.bovdog.bean.ClinicalRecord;


public class ClinicalRecordDAO {
	
  private EntityManager entityManager = null;

  public ClinicalRecordDAO() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("techvet-unit");
    this.entityManager = factory.createEntityManager();

  }

  public ClinicalRecord getClinicalRecordById(int id) {
    ClinicalRecord record = entityManager.find(ClinicalRecord.class, id);
    return record;
  }

  public List<ClinicalRecord> getAllClinicalRecords() {
    List<ClinicalRecord> records = new ArrayList<ClinicalRecord>();
    records = entityManager.createQuery("FROM " + ClinicalRecord.class.getName()).getResultList();
    return records;
  }

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
