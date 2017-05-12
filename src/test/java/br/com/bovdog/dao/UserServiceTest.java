package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.bovdog.bean.User;
import br.com.bovdog.helper.PersistenceHelper;
import br.com.bovdog.service.UserService;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

	private User user;
	private final String TEST_UNIT = "test-unit";
	private UserService userService;
	private DataAccessObject testDAO;
	
	@Before
	public void setUp() {
		user = setupUser();
		testDAO = new DataAccessObject(TEST_UNIT);
		userService = new UserService(testDAO);
	}
	
	@After
	public void clearDatabase() {
		PersistenceHelper.clearDatabase();
	}
	
	public User setupUser() {
		User user = new User();
		
		user.setUserFullName("String");
		user.setUserName("String");
		user.setUserPassword("String");
		
		return user;
	}
	
	@Test
	public void createUserTest() {
		int id = userService.createUser(user).getId();
		assertEquals(user, testDAO.getObjectById(id, User.class));
	}

	@Test
	public void getListOfUsersTest() {
		UriInfo ui = mock(UriInfo.class);
		when(ui.getQueryParameters()).thenReturn(null);
		List<User> users = new ArrayList<User>();
		
		for (int i = 0; i < 3; i++) {
			User user = setupUser();
			user.setUserName("User " + i);
			user = testDAO.createObject(user);
			users.add(user);
		}
		
		assertEquals(users, userService.getAllUsers(ui));
	}
	
	@Test
	public void deleteUserTest() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = setupUser();
			user.setUserName("User " + i);
			user = testDAO.createObject(user);
			users.add(user);
		}

		userService.deleteUser(users.get(0).getId());
		
		assertEquals(users.size() - 1, testDAO.getAllObjects(null, User.class).size());
	}
	
}
