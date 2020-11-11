package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	@Autowired
	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			{
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(1, "sandwich", 99.00f, true, new DateUtil().convertToDate("15/03/2017"),
						"Main Course", true));
				menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, new DateUtil().convertToDate("23/12/2017"),
						"Main Course", false));
				menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, new DateUtil().convertToDate("21/08/2018"),
						"Main Course", false));
				menuItemList.add(new MenuItem(4, "French Fries", 57.00f, false,
						new DateUtil().convertToDate("02/07/2017"), "Starters", true));
				menuItemList.add(new MenuItem(000005, "Chocolate Brownie", 32.00f, true,
						new DateUtil().convertToDate("02/11/2022"), "Dessert", true));
			}
		}
	}
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;

	}
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customermenu = new ArrayList<MenuItem>();
		Date current = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= current.getTime() && menuItem.isActive()) {
				customermenu.add(menuItem);
			}
		}

		return customermenu;

	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem mitem : menuItemList) {
			if (mitem.equals(menuItem)) {
				mitem.setName(menuItem.getName());
				mitem.setCategory(menuItem.getCategory());
				mitem.setDateOfLaunch(menuItem.getDateOfLaunch());
				mitem.setFreeDelivery(menuItem.isFreeDelivery());
				mitem.setPrice(menuItem.getPrice());
				mitem.setActive(menuItem.isActive());
			}
		}
	}
	@Override
	public MenuItem getMenuItem(long menuItemId)

	{
		for (MenuItem menuitem : menuItemList) {
			if (menuitem.getId() == menuItemId)
				return menuitem;
		}
		return null;

	}

}
