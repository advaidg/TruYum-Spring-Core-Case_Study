package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author Advaid Gireesan
 *
 */
public interface MenuItemDao {
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException;

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException;

	/**
	 * 
	 * @param menuitem
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void modifyMenuItem(MenuItem menuitem)
			throws ClassNotFoundException, IOException, SQLException, ParseException;

	/**
	 * 
	 * @param menuItemId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException, SQLException;

}
