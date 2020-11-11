package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {
	CartService cartService;
	MenuItemService menuItemService;

	@Before
	public void initializeService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// context.scan("com.cognizant.truyum");
		// context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
		cartService = (CartService) context.getBean("CartService");

	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItems() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList = cartService.getAllCartItems(1);
		System.out.println(menuItemList);
		//assertFalse(!menuItemList.isEmpty());

	}

	@Test
	public void testAddCartItem() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItem;
		menuItem = cartService.getAllCartItems(2);
		System.out.println(menuItem);
		cartService.addCartItem(2, 5);
		List<MenuItem> menuItemAfter;
		menuItemAfter = cartService.getAllCartItems(2);
		boolean result=false;
		int s1=menuItem.size();
		System.out.println(s1+" "+menuItemAfter.size());
		for(MenuItem m : menuItemAfter)
		{
			if(m.getName().contentEquals("Chocolate Brownie"))
			{
				result= true;
			}
		}
		assertTrue(result);

	}

	@Test
	public void testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		List<MenuItem> menuItemList;

		cartService.addCartItem(1, 1);
		menuItemList = cartService.getAllCartItems(1);
		cartService.removeCartItem(1, 1);
		List<String> menuItems = new ArrayList<String>();

		for (int i = 0; i < menuItemList.size(); i++) {

			menuItems.add(menuItemList.get(i).getName());

		}

		assertTrue(!menuItems.contains("Sandwich"));

	}

}