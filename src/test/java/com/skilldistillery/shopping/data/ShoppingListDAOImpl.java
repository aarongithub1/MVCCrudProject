package com.skilldistillery.shopping.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ShoppingListDAOImpl implements ShoppingListDAO {
	
	private int id = 1;
	Map<Integer, ShoppingList> shoppingList;
	
	
	public ShoppingListDAOImpl() {
		shoppingList = new HashMap<>();
		loadList();
	}
	
	public void loadList() {
		shoppingList.put(id, new ShoppingList(id++, "Eggs", 2, 2.00));
		shoppingList.put(id, new ShoppingList(id++, "Spinach", 2, 2.00));
		shoppingList.put(id, new ShoppingList(id++, "Milk", 1, 3.50));
		shoppingList.put(id, new ShoppingList(id++, "Hashbrowns", 1, 4.25));
		shoppingList.put(id, new ShoppingList(id++, "Bacon", 1, 5.50));
	}

	@Override
	public List<ShoppingList> getShoppingList() {
		return new ArrayList<ShoppingList>(shoppingList.values());
	}
	
	@Override
	public ShoppingList getListItemById(int id) {
		return shoppingList.get(id);
	}

	@Override
	public ShoppingList addItemToList(ShoppingList s) {
		return shoppingList.put(s.getId(), s);
	}


	@Override
	public ShoppingList updateShoppingList(ShoppingList s) {
		return shoppingList.put(s.getId(), s);
	}

	@Override
	public ShoppingList deleteItemFromList(ShoppingList s) {
		return shoppingList.remove(s.getId());
	}

}
