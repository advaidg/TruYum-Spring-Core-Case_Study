/**
 * 
 */
package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author Advaid Gireesan
 *
 */
//@Configuration
//@ComponentScan("com.cognizant.*")
public class MenuItemServiceTest {

	private MenuItemService menuItemService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext();
		 context.scan("com.cognizant.truyum");
		 context.refresh();
		menuItemService = context.getBean(MenuItemService.class);

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

		assertEquals(3, menuItemList.size());

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries()
			throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuList = menuItemService.getMenuItemListCustomer();
		boolean result = false;
		for (MenuItem m : menuList) {
			if (m.getName().contentEquals("French Fries"))
				result = true;
		}
		assertFalse(result);


	}

	@Test
	public void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {

		MenuItem menuItem = menuItemService.getMenuItem(1);
		menuItem = menuItemService.getMenuItem(1);
		assertTrue(menuItem.getName().equals("Sandwich"));

	}

}
