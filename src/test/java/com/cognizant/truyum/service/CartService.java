package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartService {
	@Autowired
	private CartDao cartDao;
	
	
	public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public void addCartitem(long userId,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		cartDao.addCartItem(userId, menuItemId);
		
	}
	public List<MenuItem> getAllCartitems(long userId) throws ClassNotFoundException, CartEmptyException, IOException, SQLException
	{
		List<MenuItem> result=cartDao.getAllCartItems(userId);
		return result;
	}
}
