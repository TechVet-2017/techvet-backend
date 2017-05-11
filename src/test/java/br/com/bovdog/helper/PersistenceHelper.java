package br.com.bovdog.helper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersistenceHelper {

	private static final EntityManager entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("test-unit")
				.createEntityManager();
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void clearDatabase() {
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery("TRUNCATE SCHEMA PUBLIC AND COMMIT").executeUpdate();
		entityManager.getTransaction().commit();
	}
}
