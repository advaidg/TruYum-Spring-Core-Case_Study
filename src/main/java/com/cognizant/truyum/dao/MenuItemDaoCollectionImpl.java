package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
@Component
@ImportResource("spring.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	@Autowired
	@Qualifier("menuItemList")
	List<MenuItem> menuItemList;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
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
