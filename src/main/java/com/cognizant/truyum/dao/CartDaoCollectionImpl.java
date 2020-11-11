package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private Map<Long, Cart> userCarts;

	public Map<Long, Cart> getUserCarts() {
		return this.userCarts;
	}

	public void setUserCarts(Map<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}



	@Override
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao MenuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = MenuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			List<MenuItem> list = userCarts.get(userId).getMenuItemList();
			list.add(menuItem);
			userCarts.get(userId).setMenuItemList(list);

		}

		else {
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart cart = new Cart(menuItemList);
			userCarts.put(userId, cart);

		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		double total = 0;
		Cart c = userCarts.get(userId);
		List<MenuItem> allItems = c.getMenuItemList();
		if (allItems.isEmpty()) {
			throw new CartEmptyException();
		} else {
			for (MenuItem m : allItems) {
				total = total + m.getPrice();
			}
			c.setTotal(total);
		}
		return allItems;

	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		Cart c = userCarts.get(userId);
		List<MenuItem> allItems = c.getMenuItemList();
		MenuItem remove = null;
		for (MenuItem m : allItems) {
			if (m.getId() == menuItemId) {
				remove = m;
			}
		}
		allItems.remove(remove);
		Cart x = userCarts.get(userId);
		x.setMenuItemList(allItems);

		userCarts.put(userId, x);
	}

}
