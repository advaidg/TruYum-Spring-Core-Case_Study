package com.cognizant.truyum.model;

import java.util.Date;

public class MenuItem {
	
	private long id;
	private String name;
	private float price;
	public MenuItem() {
		super();
	}

	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;
	
	public MenuItem(long id, String name, float price, boolean active, Date dateofLaunch, String category,
			boolean freeDelivery) {
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
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setDateOfLaunch(Date dateofLaunch) {
		this.dateOfLaunch = dateofLaunch;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateofLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
