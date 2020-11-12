package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service("CartService")
/**
 * 
 * @author Advaid Gireesan Service Class
 */
public class CartService {
	@Autowired
	/**
	 * 
	 */
	private CartDao cartDao;

	public void setCartDao(final CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addCartItem(final long userId, final long menuItemId)
			throws ClassNotFoundException, IOException, SQLException {

		cartDao.addCartItem(userId, menuItemId);

	}

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws ClassNotFoundException
	 * @throws CartEmptyException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void removeCartItem(final long userId, final long menuItemId)
			throws ClassNotFoundException, CartEmptyException, IOException, SQLException {
		cartDao.removeCartItem(userId, menuItemId);
	}

	/**
	 * 
	 * @param userid
	 * @return
	 * @throws CartEmptyException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<MenuItem> getAllCartItems(final long userid)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		return cartDao.getAllCartItems(userid);

	}
}
