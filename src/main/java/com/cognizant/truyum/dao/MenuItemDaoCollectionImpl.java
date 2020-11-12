package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("spring.xml")
/**
 * 
 * @author Advaid Gireesan Implements MenuItemDao Interface
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	/**
	 * List Of MenuItems("Sandwich..")
	 */
	private List<MenuItem> menuItemList;

	/**
	 * Default Constructor
	 */
	public MenuItemDaoCollectionImpl() {
		super();
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(final List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;

	}

	/**
	 * Returns list of MenuItems whose date of launch is before current date
	 * 
	 * @return
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		final List<MenuItem> customermenu = new ArrayList<MenuItem>();
		final Date current = new Date();
		for (final MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= current.getTime() && menuItem.isActive()) {
				customermenu.add(menuItem);
			}
		}

		return customermenu;

	}

	/**
	 * Gets the details of modified menuItem from user Checks for id match Then
	 * details of the menuItem is changed
	 * 
	 * @param menuItem
	 */
	@Override
	public void modifyMenuItem(final MenuItem menuItem) {
		for (final MenuItem mitem : menuItemList) {
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

	/**
	 * Takes input of menuItemId and returns that menuItem from the list of
	 * MenuItems
	 * 
	 * @param menuItemId
	 * @return
	 */
	@Override
	public MenuItem getMenuItem(final long menuItemId)

	{
		for (final MenuItem menuitem : menuItemList) {
			if (menuitem.getId() == menuItemId)
				return menuitem;
		}
		return null;

	}

}
