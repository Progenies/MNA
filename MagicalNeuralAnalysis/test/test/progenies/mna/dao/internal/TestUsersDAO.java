package test.progenies.mna.dao.internal;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.progenies.mna.dao.internal.UsersDAO;
import com.progenies.mna.model.internal.User;

import test.progenies.mna.utils.SpringUtils;

public class TestUsersDAO {

	private static ApplicationContext context;
	private static UsersDAO usersDAO;
	
	private static final String LOGIN="UNKOWN_LOGIN_JAJLALALAL sdsakldjslakjeklweq SDF WDAR WEF SDGGWER4343543 $$$$·!!@";
	
	private static long insertedUserID=-1;
	
	@BeforeClass
	public static void setUp()
	{
		context=SpringUtils.createContext();
		usersDAO=(UsersDAO) context.getBean("usersDAO");
	}
	
	
	
	@Test
	public void testUserByIdNotFound()
	{
		User user=usersDAO.getUserByID(insertedUserID);
		assertNull(user);
	}

	@Test(expected=NoResultException.class)
	public void testUserByLoginNotFound()
	{
		User user=usersDAO.getUserByLogin(LOGIN);
		fail("Deberia haber saltado excepción pero devolvión user="+user);
	}
	
	@Test
	public void testInsertUser()
	{
		User user=new User();
		user.setActive(false);
		user.setLogin(LOGIN);
		user.setName(LOGIN);
		user.setPassword("PASSSSS");
		assertNull(user.getIdUser());
		user=usersDAO.insertUser(user);
		assertNotNull(user.getIdUser());
		
		this.insertedUserID=user.getIdUser();
		System.out.println("Insertado usuario '"+insertedUserID+"'");
	}
	
	
	@Test
	public void testUserByIdFound()
	{
		User user=usersDAO.getUserByID(insertedUserID);
		assertNotNull(user);
		assertEquals(LOGIN, user.getLogin());
		assertEquals(LOGIN, user.getName());
	}

	@Test
	public void testUserByLoginFound()
	{
		User user=usersDAO.getUserByLogin(LOGIN);
		assertNotNull(user);
		assertEquals(LOGIN, user.getLogin());
		assertEquals(LOGIN, user.getName());
	}
	
	@Test
	public void testAllUsers()
	{
		List<User> users=usersDAO.findAllUsers();
		assertNotNull(users);
		assertTrue(users.size()>0);
	}
	
	@Test
	public void testUserModify()
	{
		User user=usersDAO.getUserByID(insertedUserID);
		assertNotNull(user);
		assertEquals(LOGIN, user.getLogin());
		assertEquals(LOGIN, user.getName());
		assertFalse(user.getActive());
		
		user.setName("NOMBRE_MODIFICADO");
		user.setActive(Boolean.TRUE);
		usersDAO.updateUser(user);
		
		//leo de nuevo apra asegurarme que es otro objeto
		User user2=usersDAO.getUserByID(insertedUserID);
		assertNotNull(user2);
		assertEquals(LOGIN, user2.getLogin());
		assertEquals("NOMBRE_MODIFICADO", user2.getName());
		assertTrue(user2.getActive());
		
	}
	
	@Test
	public void testDeleteUser()
	{
		User user=usersDAO.getUserByID(insertedUserID);
		assertNotNull(user);
		usersDAO.deleteUser(user);
		testUserByIdNotFound();
	}
	

	
	
	
	
	
	@AfterClass
	public static void tearDown()
	{
		SpringUtils.closeContext(context);
	}

}
