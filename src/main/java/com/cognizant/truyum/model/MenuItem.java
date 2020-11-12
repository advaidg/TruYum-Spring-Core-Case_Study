package com.cognizant.truyum.model;

import java.util.Date;
/**
 * 
 * @author Advaid Gireesan
 *
 */
public class MenuItem {
	/**
	 * 
	 */
	private long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private float price;
	
	/**
	 * 
	 * 
	 */
	private boolean active;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private Date dateOfLaunch;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private boolean freeDelivery;
	/**
	 * 
	 */
	public MenuItem() {
		super();
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param active
	 * @param dateofLaunch
	 * @param category
	 * @param freeDelivery
	 */
	public MenuItem(final long id, final String name, final float price, final boolean active, final Date dateofLaunch, final String category,
			final boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateofLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public boolean isActive() {
		return active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public String getCategory() {
		return category;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setId(final long id) {
		this.id = id;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public void setPrice(final float price) {
		this.price = price;
	}
	public void setActive(final boolean active) {
		this.active = active;
	}
	public void setDateOfLaunch(final Date dateofLaunch) {
		this.dateOfLaunch = dateofLaunch;
	}
	public void setCategory(final String category) {
		this.category = category;
	}
	public void setFreeDelivery(final boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateofLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	/**
	 * 
	 */
	@SuppressWarnings("PMD.OnlyOneReturn")
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("PMD.LocalVariableCouldBeFinal")
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
		{	return false;
		
		}
		return true;
	}
	
	
}
