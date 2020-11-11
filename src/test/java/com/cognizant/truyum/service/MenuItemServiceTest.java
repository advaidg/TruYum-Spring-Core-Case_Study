/**
 * 
 */
package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

/**
 * @author Advaid Gireesan
 *
 */
public class MenuItemServiceTest {

	private MenuItemService menuItemService;

	@Before
	public void  initializeService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// context.scan("com.cognizant.truyum");
		// context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");

	}

	@Test
	public void testGetMenuItemListAdminSize() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuList = menuItemService.getMenuItemListAdmin();
		assertEquals(5, menuList.size());

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
	@Test
	public void testGetMenuItemListCustomerSize() throws ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		
		assertEquals(3,menuItemList.size());
		
	}
}
