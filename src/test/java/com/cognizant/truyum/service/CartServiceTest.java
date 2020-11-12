package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author Advaid Gireesan
 *
 */
public class CartServiceTest {
	/**
	 * 
	 */
	private CartService cartService;
	/**
	 * 
	 */
	private MenuItemService menuItemService;

	@Before
	/**
	 * 
	 */
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = context.getBean(MenuItemService.class);
		cartService = (CartService) context.getBean("CartService");
		context.close();

	}

	@Test(expected = CartEmptyException.class)
	/**
	 * 
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void testGetAllCartItems() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		final List<MenuItem> menuItemList = cartService.getAllCartItems(1);
		System.out.println(menuItemList);
		// assertFalse(!menuItemList.isEmpty());

	}

	@Test
	/**
	 * 
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void testAddCartItem() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItem;
		menuItem = cartService.getAllCartItems(2);
		System.out.println(menuItem);
		cartService.addCartItem(2, 5);
		List<MenuItem> menuItemAfter;
		menuItemAfter = cartService.getAllCartItems(2);
		boolean result = false;
		final int s1 = menuItem.size();
		System.out.println(s1 + " " + menuItemAfter.size());
		for (MenuItem m : menuItemAfter) {
			if (m.getName().contentEquals("Chocolate Brownie")) {
				result = true;
			}
		}
		assertTrue(result);

	}

	@Test
	/**
	 * 
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList;

		cartService.addCartItem(1, 1);
		menuItemList = cartService.getAllCartItems(1);
		cartService.removeCartItem(1, 1);
		final List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(menuItemList.get(i).getName());

		}

		assertTrue(!menuItems.contains("Sandwich"));

	}

}