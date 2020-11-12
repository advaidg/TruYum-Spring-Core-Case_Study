package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

/**
 * 
 * @author Advaid Gireesan 
 * Implements CARTDAO interface
 */
public class CartDaoCollectionImpl implements CartDao {
	/**
	 * Map
	 */
	private Map<Long, Cart> userCarts;
	/**
	 * MenuItemDao Object
	 */
	private MenuItemDao menuItemDao;

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(final MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public Map<Long, Cart> getUserCarts() {
		return this.userCarts;
	}

	/**
	 * @param userCarts
	 */
	public void setUserCarts(final Map<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	/**
	 * Depending on the userId and menuItemId the corresponding menuItem is added in
	 * cart against the UserID
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addCartItem(final long userId, final long menuItemId)
			throws ClassNotFoundException, IOException, SQLException {
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		final MenuItemService menutItemService = (MenuItemService) ctx.getBean("menuItemService");
		final MenuItem menuItem = menutItemService.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			final List<MenuItem> list = userCarts.get(userId).getMenuItemList();

			list.add(menuItem);
			userCarts.get(userId).setMenuItemList(list);

		}

		else {
			final List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			final Cart cart = new Cart(menuItemList);
			userCarts.put(userId, cart);

		}
		ctx.close();
	}

	/**
	 * Return list of menuItems for the given UserId
	 * 
	 * @param userId
	 * @return
	 * @throws CartEmptyException
	 */
	@Override
	public List<MenuItem> getAllCartItems(final long userId) throws CartEmptyException {

		final Cart cart = userCarts.get(userId);
		final List<MenuItem> allItems = cart.getMenuItemList();
		if (allItems.isEmpty()) {
			throw new CartEmptyException();
		} else {
			double total = 0;
			for (final MenuItem menuItem : allItems) {
				total = total + menuItem.getPrice();
			}
			cart.setTotal(total);
		}
		return allItems;

	}

	/**
	 * Removes a particular item from the given Users Cart
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws CartEmptyException
	 */
	@Override
	public void removeCartItem(final long userId, final long menuItemId) throws CartEmptyException {
		final Cart cart = userCarts.get(userId);
		final List<MenuItem> allItems = cart.getMenuItemList();

		MenuItem remove = null;
		for (final MenuItem menuitem : allItems) {
			if (menuitem.getId() == menuItemId) {
				remove = menuitem;
			}
		}
		allItems.remove(remove);
		final Cart cart1 = userCarts.get(userId);
		cart1.setMenuItemList(allItems);

		userCarts.put(userId, cart1);
	}
}
