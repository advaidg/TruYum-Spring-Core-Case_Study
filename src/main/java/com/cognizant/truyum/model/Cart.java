package com.cognizant.truyum.model;

import java.util.List;

/**
 * 
 * @author Advaid Gireesan
 *Model Class Cart
 */
public class Cart {
	/**
	 * 
	 */
	private List<MenuItem> menuItemList;
	/**
	 * 
	 */
	private double total;

	/**
	 * 
	 * @param menuItemList
	 */
	public Cart(final List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;

	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public double getTotal() {
		return total;
	}

	/**
	 */
	public void setMenuItemList(final List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(final double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
