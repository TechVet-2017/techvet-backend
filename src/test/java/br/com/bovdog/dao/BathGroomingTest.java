package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.bean.User;
import br.com.bovdog.helper.PersistenceHelper;
import br.com.bovdog.service.BathGroomingService;

public class BathGroomingTest {

	private BathGrooming bathGrooming;
	private final String TEST_UNIT = "test-unit";
	private BathGroomingService bathGroomingService;
	private DataAccessObject testDao;

	@Before
	public void setup() {
		bathGrooming = setupBathGrooming();
		testDao = new DataAccessObject(TEST_UNIT);
		bathGroomingService = new BathGroomingService(testDao);
	}

	@After
	public void clearDatabase() {
		PersistenceHelper.clearDatabase();
	}

	public BathGrooming setupBathGrooming() {
		BathGrooming bathGrooming = new BathGrooming();

		bathGrooming.setServiceBathGrooming("Service");

		return bathGrooming;
	}

	@Test
	public void createBathGroomingTest() {
		int id = bathGroomingService.createBathGrooming(bathGrooming).getId();
		assertEquals(bathGrooming, testDao.getObjectById(id, BathGrooming.class));
	}

	@Test
	public void listAllBathGroomingTest() {
		UriInfo ui = mock(UriInfo.class);
		when(ui.getQueryParameters()).thenReturn(null);
		List<BathGrooming> bathGroomings = new ArrayList<BathGrooming>();
		for (int i = 0; i < 3; i++) {
			BathGrooming bathGrooming = setupBathGrooming();
			bathGrooming.setServiceBathGrooming("Service " + i);
			bathGrooming = testDao.createObject(bathGrooming);
			bathGroomings.add(bathGrooming);
		}
		assertEquals(bathGroomings, bathGroomingService.getAllBathGroomings(ui));
	}

	@Test
	public void updateBathGroomingTest() {
		BathGrooming bathGrooming = setupBathGrooming();
		bathGrooming = bathGroomingService.createBathGrooming(bathGrooming);

		assertEquals(testDao.getObjectById(bathGrooming.getId(), BathGrooming.class)
				.getServiceBathGrooming(), "Service");

		bathGrooming.setServiceBathGrooming("ServiceUpdate");
		bathGrooming = bathGroomingService.updateBathGrooming(bathGrooming.getId(), bathGrooming);

		assertEquals(testDao.getObjectById(bathGrooming.getId(), BathGrooming.class)
				.getServiceBathGrooming(), "ServiceUpdate");
		
	}
	
	@Test
	public void deleteBathGroomingTest(){
	 	List<BathGrooming> bathGroomings = new ArrayList<BathGrooming>();
	 	for (int i = 0; i < 3; i++) {
	 		BathGrooming bathGrooming = setupBathGrooming();
	 		bathGrooming.setServiceBathGrooming("Service " + i);
	 		bathGrooming = testDao.createObject(bathGrooming);
	 		bathGroomings.add(bathGrooming);
	 	}
	 	 
	 	bathGroomingService.deleteBathGroomingById(bathGroomings.get(0).getId());
	 	 
	 	assertEquals(bathGroomings.size()-1, testDao.getAllObjects(null, BathGrooming.class).size());
	 }
	@Test
	public void getBathGroomingByIdTest() {
		BathGrooming bathgrooming = setupBathGrooming();
		bathgrooming = bathGroomingService.createBathGrooming(bathgrooming);

		assertEquals(bathGroomingService.getBathGroomingById(bathgrooming.getId()), bathgrooming);
	}

}
