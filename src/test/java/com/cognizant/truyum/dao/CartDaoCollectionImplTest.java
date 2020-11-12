package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	/**
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}
	/**
	 * 
	 * @throws ParseException
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testAddCartItem() throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 4);
		final List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		menuItemList.forEach(System.out::println);

	}
	/**
	 * 
	 * @throws ParseException
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testGetAllCartItems() throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		final CartDao cartDao = new CartDaoCollectionImpl();
		final List<MenuItem> menuItem = cartDao.getAllCartItems(1);
		menuItem.forEach(System.out::println);

	}
	/**
	 * 
	 * @throws ParseException
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void testRemoveCartItem() throws ParseException, CartEmptyException, ClassNotFoundException, IOException, SQLException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 4);
		testGetAllCartItems();

	}
}
