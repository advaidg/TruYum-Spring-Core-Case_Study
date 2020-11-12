package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author Advaid Gireesan
 *
 *Interface for maintaining and performing operations on MENU ITEMS in Cart
 */
public interface CartDao {
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	List<MenuItem> getAllCartItems(long userId)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	/**
	 * 
	 * @param userUd
	 * @param menuItemId
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	void removeCartItem(long userUd, long menuItemId)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

}
