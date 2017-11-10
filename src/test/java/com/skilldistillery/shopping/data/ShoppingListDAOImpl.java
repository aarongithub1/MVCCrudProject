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
	
	Map<Integer, ShoppingList> shoppingList;
	
	public ShoppingListDAOImpl() {
		shoppingList = new HashMap<>();
		loadList();
	}
	
	public void loadList() {
		shoppingList.put(1, new ShoppingList(1, "Eggs", 2, 2.00));
		shoppingList.put(2, new ShoppingList(2, "Spinach", 2, 2.00));
		shoppingList.put(3, new ShoppingList(3, "Milk", 1, 3.50));
		shoppingList.put(4, new ShoppingList(4, "Hashbrowns", 1, 4.25));
		shoppingList.put(5, new ShoppingList(5, "Bacon", 1, 5.50));
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
