package test.progenies.mna.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import test.progenies.mna.utils.SpringUtils;

import com.progenies.mna.menu.Menu;
import com.progenies.mna.menu.MenuEntry;

public class TestMenu
{
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUp()
	{
		context=SpringUtils.createContext();
	}
	
	
	@Test
	public void testLoadMenu()
	{
		Menu menu=context.getBean(Menu.class);
		assertNotNull(menu);
		assertNotNull(menu.getEntries());
		assertEquals(2, menu.getEntries().size());
		
		//entradas
		MenuEntry entry1=menu.getEntries().get(0);
		MenuEntry entry2=menu.getEntries().get(1);
		
		//verifico su contenido
		assertNotNull(entry1);
		assertEquals("KEY_WELCOME", entry1.getNameKey());
		assertEquals("/index.jsp", entry1.getUrl());
		assertNull(entry1.getChilds());

		assertNotNull(entry2);
		assertEquals("KEY_MAINTENANCE", entry2.getNameKey());
		assertNull(entry2.getUrl());
		assertNotNull(entry2.getChilds());
		assertEquals(3, entry2.getChilds().size());
		
		//no verifico los internos ya uqe usa el mismo código
}
	
	
	
	
	
	
	
	
	@AfterClass
	public static void tearDown()
	{
		SpringUtils.closeContext(context);
	}

}
