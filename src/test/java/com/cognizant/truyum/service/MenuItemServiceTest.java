/**
 * 
 */
package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

/**
 * @author Advaid Gireesan
 *
 */
public class MenuItemServiceTest {
	
	private MenuItemService menuItemService;
	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");

	}

	@Test
	public void testGetMenuItemListAdminSize() throws ClassNotFoundException, IOException, SQLException {
		
		

	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuList = menuItemService.getMenuItemListAdmin();
		boolean result = false;
		for (MenuItem m : menuList) {
			if (m.getName().contentEquals("Sandwich"))
				result = true;
		}
		assertTrue(result);

	}
}
