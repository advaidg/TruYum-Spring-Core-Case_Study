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
public class CartService {
	@Autowired
	private CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {

		cartDao.addCartItem(userId, menuItemId);

	}

	public void removeCartItem(long userId, long menuItemId)
			throws ClassNotFoundException, CartEmptyException, IOException, SQLException {
		cartDao.removeCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(long userid)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException {

		return cartDao.getAllCartItems(userid);

	}
}
