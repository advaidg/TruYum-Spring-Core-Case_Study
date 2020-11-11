package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
@Service("menuItemService")
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;

	public void setMenuItemDao(MenuItemDao menuItemDao) {

	}

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		return menuItemDao.getMenuItemListAdmin();

	}

	public List<MenuItem> getMenuItemListCustomer() {
		return null;

	}

	public MenuItem getMenuItem(long menuItemId) {
		return null;

	}

	public void editMenuItem(MenuItem menuItem) {

	}

}
