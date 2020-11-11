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

public class CartDaoCollectionImpl implements CartDao {

	private Map<Long, Cart> userCarts;

	public Map<Long, Cart> getUserCarts() {
		return this.userCarts;
	}

	public void setUserCarts(Map<Long, Cart> userCarts) {
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
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		MenuItemService menutItemService = (MenuItemService) ctx.getBean("menuItemService");
		MenuItem menuItem = menutItemService.getMenuItem(menuItemId);
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
//package com.cognizant.truyum.dao;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import com.cognizant.truyum.model.Cart;
//import com.cognizant.truyum.model.MenuItem;
//
//@Component
//public class CartDaoCollectionImpl implements CartDao {
//
//    
//    private Map<Long, Cart> userCarts;
//
//    public Map<Long, Cart> getUserCarts() {
//        return userCarts;
//    }
//
//    public void setUserCarts(Map<Long, Cart> userCarts) {
//        this.userCarts = userCarts;
//    }
//
//    @Override
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
//
//    @Override
//    public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
//
//        Cart cart = userCarts.get(userId);
//        List<MenuItem> allCartItems = cart.getMenuItemList();
//        if (allCartItems.isEmpty() || allCartItems == null) {
//            throw new CartEmptyException();
//        } else {
//            double total = 0;
//            for (MenuItem item : allCartItems) {
//                total += item.getPrice();
//            }
//            
//            cart.setTotal(total);
//        }
//        return allCartItems;
//    }
//
//    @Override
//    public void removeCartItem(long userId, long menuItemId) {
//
//        Cart cart = userCarts.get(userId);
//        List<MenuItem> allCartItems = cart.getMenuItemList();
//        MenuItem itemToRemove = null;
//
//        for (MenuItem item : allCartItems) {
//            if (item.getId() == menuItemId) {
//                itemToRemove = item;
//                break;
//            }
//        }
//        allCartItems.remove(itemToRemove);
//        cart.setMenuItemList(allCartItems);
//        userCarts.put(userId, cart);
//    }
//}