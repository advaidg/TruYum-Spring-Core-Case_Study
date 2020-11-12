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
 *
 */
public class CartDaoCollectionImpl implements CartDao {
	/**
	 * 
	 */
	private Map<Long, Cart> userCarts;
	/**
	 * 
	 */
	private MenuItemDao menuItemDao;

	/**
	 * 
	 * @return
	 */
	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	/**
	 * 
	 * @param menuItemDao
	 */
	public void setMenuItemDao(final MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	/**
	 * 
	 * @return
	 */
	public Map<Long, Cart> getUserCarts() {
		return this.userCarts;
	}

	/**
	 * 
	 * @param userCarts
	 */
	public void setUserCarts(final Map<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

//	@Override
//    public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {
//
//        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//        MenuItem item = menuItemDao.getMenuItem(menuItemId);
//
//        if (userCarts.containsKey(userId)) {
//            List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
//            menuItemList.add(item);
//            userCarts.get(userId).setMenuItemList(menuItemList);
//        } else {
//            List<MenuItem> newUserMenuList = new ArrayList<>();
//            newUserMenuList.add(item);
//            Cart cart = new Cart(newUserMenuList);
//            userCarts.put(userId, cart);
//        }
//
//    }

	@Override
	/**
	 * 
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

	@Override
	/**
	 * 
	 */
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

	@Override
	/**
	 * 
	 */
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
