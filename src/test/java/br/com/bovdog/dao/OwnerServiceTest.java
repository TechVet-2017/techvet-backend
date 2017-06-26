package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import br.com.bovdog.bean.BathGrooming;
import br.com.bovdog.bean.ClinicalRecordAppointment;
import br.com.bovdog.bean.Owner;
import br.com.bovdog.helper.PersistenceHelper;
import br.com.bovdog.service.OwnerService;

public class OwnerServiceTest {

	private Owner owner;
	private final String TEST_UNIT = "test-unit";
	private OwnerService ownerService;
	private DataAccessObject testDao;

	@Before
	public void setup() {
		owner = setupOwner();
		testDao = new DataAccessObject(TEST_UNIT);
		ownerService = new OwnerService(testDao);
	}

	@After
	public void clearDatabase() {
		PersistenceHelper.clearDatabase();
	}

	public Owner setupOwner() {
		Owner owner = new Owner();

		owner.setAddressNumber(1L);
		owner.setCity("String");
		owner.setComplement("String");
		owner.setCpf("String");
		owner.setDistrict("String");
		owner.setNeighborhood("String");
		owner.setOwnerLastName("String");
		owner.setOwnerName("String");
		owner.setPhoneNumber("String");
		owner.setPublicPlace("String");
		owner.setZipCode("String");

		return owner;
	}

	@Test
	public void createOwnerTest() {
		int id = ownerService.createOwner(owner).getId();
		
		assertEquals(owner, testDao.getObjectById(id, Owner.class));
	}
	@Test
	public void getAtributes(){
		String city = ownerService.createOwner(owner).getCity();
		String neighborhood = ownerService.createOwner(owner).getNeighborhood();
		String cpf = ownerService.createOwner(owner).getCpf();
		String ownerLastName = ownerService.createOwner(owner).getOwnerLastName();
		String phoneNumber = ownerService.createOwner(owner).getPhoneNumber();
		String zipCode = ownerService.createOwner(owner).getZipCode();
		assertEquals(city, owner.getCity());
		assertEquals(neighborhood, owner.getCity());
		assertEquals(cpf, owner.getCpf());
		assertEquals(ownerLastName, owner.getOwnerLastName());
		assertEquals(phoneNumber, owner.getPhoneNumber());
		assertEquals(zipCode, owner.getZipCode());
	}
	@Test
	public void listAllOwnersWithoutQueriesTest() {
		UriInfo ui = mock(UriInfo.class);
		when(ui.getQueryParameters()).thenReturn(null);
		List<Owner> owners = new ArrayList<Owner>();
		for (int i = 0; i < 3; i++) {
			Owner owner = setupOwner();
			owner.setOwnerName("Owner " + i);
			owner = testDao.createObject(owner);
			owners.add(owner);
		}
		assertEquals(owners, ownerService.getAllOwners(ui));
	}

	@Test
	public void listAllOwnersWithSortAndOrderQueries() {
		UriInfo ui = mock(UriInfo.class);
		@SuppressWarnings("unchecked")
		MultivaluedMap<String, String> queryParameters = mock(MultivaluedMap.class);
		when(queryParameters.containsKey("_sort")).thenReturn(true);
		when(queryParameters.containsKey("_order")).thenReturn(true);
		when(queryParameters.getFirst("_sort")).thenReturn("ownerName");
		when(queryParameters.getFirst("_order")).thenReturn("desc");
		when(ui.getQueryParameters()).thenReturn(queryParameters);
		List<Owner> owners = new ArrayList<Owner>();
		for (int i = 0; i < 3; i++) {
			Owner owner = setupOwner();
			owner.setOwnerName("Owner " + i);
			owner = testDao.createObject(owner);
			owners.add(owner);
		}
		assertEquals(owners.get(0).getOwnerName(), ownerService
				.getAllOwners(ui).get(2).getOwnerName());
	}
	
	@Test
	public void updateOwnerTest() {
		Owner owner = setupOwner();
		owner = ownerService.createOwner(owner);

		assertEquals(testDao.getObjectById(owner.getId(), Owner.class).getOwnerName(), "String");

		owner.setOwnerName("OwnerNameUpdate");
		owner = ownerService.updateOwner(owner, owner.getId());

		assertEquals(testDao.getObjectById(owner.getId(), Owner.class)
				.getOwnerName(), "OwnerNameUpdate");
		
	}
	@Test
	public void deleteOwnerTest(){
	 	List<Owner> owners = new ArrayList<Owner>();
	 	for (int i = 0; i < 3; i++) {
	 		Owner owner = setupOwner();
	 		owner.setOwnerName("String " + i);
	 		owner = testDao.createObject(owner);
	 		owners.add(owner);
	 	}
	 	 
	 	ownerService.deleteOwner(owners.get(0).getId());
	 	 
	 	assertEquals(owners.size()-1, testDao.getAllObjects(null, Owner.class).size());
	 }
	 @Test
	 public void getOwnerById() {

		Owner firstOwner = setupOwner();
		firstOwner = testDao.createObject(firstOwner);
		int firstId = firstOwner.getId();

		Owner secondOwner = setupOwner();
		secondOwner = testDao.createObject(secondOwner);
		int secondId = secondOwner.getId();

		Assert.assertEquals(firstOwner,
				ownerService.getOwnerById(firstId));
		Assert.assertEquals(secondOwner, ownerService
				.getOwnerById(secondId));

	 }

}
