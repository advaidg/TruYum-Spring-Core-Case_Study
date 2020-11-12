package com.cognizant.truyum.service;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
/**
 * 
 * @author Advaid Gireesan
 *
 */
public class MenuItemService {

	@Autowired
	/**
	 * 
	 */
	private MenuItemDao menuItemDao;

	public void setMenuItemDao(final MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {

		return menuItemDao.getMenuItemListAdmin();

	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {

		return menuItemDao.getMenuItemListCustomer();
	}

	/**
	 * 
	 * @param menuItem
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void modifyMenuItem(final MenuItem menuItem)
			throws ClassNotFoundException, IOException, SQLException, ParseException {
		menuItemDao.modifyMenuItem(menuItem);

	}

	/**
	 * 
	 * @param menuitemId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public MenuItem getMenuItem(final long menuitemId) throws ClassNotFoundException, IOException, SQLException {
		return menuItemDao.getMenuItem(menuitemId);

	}

}