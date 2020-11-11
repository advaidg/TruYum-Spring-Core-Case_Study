package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
@Service("menuItemService")
public class MenuItemService {

	@Autowired
	MenuItemDao menuItemDao;

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {

		return menuItemDao.getMenuItemListAdmin();

	}

	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {

		return menuItemDao.getMenuItemListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException, ParseException {
		menuItemDao.modifyMenuItem(menuItem);

	}

	public MenuItem getMenuItem(long menuitemId) throws ClassNotFoundException, IOException, SQLException {
		return menuItemDao.getMenuItem(menuitemId);

	}

}