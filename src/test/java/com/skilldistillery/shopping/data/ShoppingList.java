package com.skilldistillery.shopping.data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ShoppingList {
	private int id;
	
	@Size(min=3, max=50, message="Type a list item between 3 and 50 characters.")
	private String listItem;
	
	@Min(value=1, message="Minimum number of item is 1.")
	@Max(value=99, message="Maximum number of items is 100.")
	private int numberOfItems;
	
	@Min(value=1, message="Minimum price of item is 1.")
	private double itemPrice;
	
	// no-args constructor
	public ShoppingList() {
		
	}
	
	// shopping list constructor
	public ShoppingList(int id, String listItem, int numberOfItems, double itemPrice) {
		super();
		this.id = id;
		this.listItem = listItem;
		this.numberOfItems = numberOfItems;
		this.itemPrice = itemPrice;
	}

	// getters/setters ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// getters/setters List items
	public String getListItem() {
		return listItem;
	}
	public void setListItem(String listItem) {
		this.listItem = listItem;
	}
	
	// getters/setters Number of items
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
	// getters/setters item price
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listItem == null) ? 0 : listItem.hashCode());
		result = prime * result + id;
		return result;
	}
	
	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingList other = (ShoppingList) obj;
		if (listItem == null) {
			if (other.listItem != null)
				return false;
		} else if (!listItem.equals(other.listItem))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	// toString
	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", ListItem=" + listItem + "]";
	}
	
}
