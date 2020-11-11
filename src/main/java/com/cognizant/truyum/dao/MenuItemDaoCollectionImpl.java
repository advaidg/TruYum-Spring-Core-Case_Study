package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	private  List<MenuItem> menuItemList;
	
	
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
