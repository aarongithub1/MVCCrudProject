package com.skilldistillery.shopping.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ShoppingListDAOImpl implements ShoppingListDAO {
	
	private int id = 1;
	Map<Integer, ShoppingList> shoppingList;
	
	
	public ShoppingListDAOImpl() {
		shoppingList = new HashMap<>();
		loadList();
	}
	
	public void loadList() {
		shoppingList.put(id, new ShoppingList(id++, "Eggs", 1, 3.75));
		shoppingList.put(id, new ShoppingList(id++, "Spinach", 1, 2.00));
		shoppingList.put(id, new ShoppingList(id++, "Milk", 1, 3.50));
		shoppingList.put(id, new ShoppingList(id++, "Hashbrowns", 1, 4.25));
		shoppingList.put(id, new ShoppingList(id++, "Bacon", 1, 5.50));
	}
	
	// add item to list, increment id
	@Override
	public ShoppingList addItemToList(ShoppingList s) {
		s.setId(id++);
		return shoppingList.put(s.getId(), s);
	}
	
	// get all items in the list
	@Override
	public List<ShoppingList> getShoppingList() {
		return new ArrayList<ShoppingList>(shoppingList.values());
	}
	
	// get list item by id
	@Override
	public ShoppingList getListItemById(int id) {
		return shoppingList.get(id);
	}

	// update list, edit list items
	@Override
	public ShoppingList updateShoppingList(ShoppingList s) {
		return shoppingList.put(s.getId(), s);
	}
	
	// delete items from list
	@Override
	public ShoppingList deleteItemFromList(ShoppingList s) {
		return shoppingList.remove(s.getId());
	}

}
