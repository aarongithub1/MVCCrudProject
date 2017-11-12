package com.skilldistillery.shopping.data;
import java.util.List;

public interface ShoppingListDAO {
	
	// get item by ID
	ShoppingList getListItemById(int id);
	
	// add items to list
	ShoppingList addItemToList(ShoppingList s);        //Create
	
	// get whole shopping list
	List<ShoppingList> getShoppingList();              //Retrieve
	
	// update shopping list
	ShoppingList updateShoppingList(ShoppingList s);   //Update
	
	// delete items from the list
	ShoppingList deleteItemFromList(ShoppingList s);   //Delete
		
}
