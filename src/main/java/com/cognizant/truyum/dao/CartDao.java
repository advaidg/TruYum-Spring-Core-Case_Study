package com.cognizant.truyum.dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException;

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

	public void removeCartItem(long userUd, long menuItemId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException;

}
