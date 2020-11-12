package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
/**
 * 
 * @author Advaid Gireesan
 *
 */
public class MenuItemDaoCollectionImplTest {
	/**
	 * 
	 */
	private static  MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}
	
	public void setMenuItemDao(final MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}
	/**
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		System.out.println("TESTING MENU ITEM LIST");
		testGetMenuItemListAdmin();
		testGetMenuListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {

		menuItemDao = new MenuItemDaoCollectionImpl();

		final List<MenuItem> menuItems = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem);
		}
	}
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testGetMenuListCustomer() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("TESTING MENU ITEM LIST CUSTOMER ");
		final List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.println(menuItemDao.toString());
		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("TESTING MODFY ITEM");
		MenuItem check = new MenuItem(1, "Berger", 1000.00f, true, new DateUtil().convertToDate("17/03/2018"),
				"Main Course", true);
		final MenuItemDaoCollectionImpl MenuItemDao = new MenuItemDaoCollectionImpl();
		MenuItemDao.modifyMenuItem(check);
		MenuItemDao.getMenuItem(1);
		testGetMenuItemListAdmin();

	}
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException, ParseException {
		System.out.println("TESTING GET MENU ITEMS");
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		menuItemDao.modifyMenuItem(newMenuItem);
		final MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem.toString());

	}
}
