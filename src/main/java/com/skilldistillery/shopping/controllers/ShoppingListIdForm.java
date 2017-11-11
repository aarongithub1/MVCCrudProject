package com.skilldistillery.shopping.controllers;

import javax.validation.constraints.NotNull;

public class ShoppingListIdForm {
	@NotNull
	private Integer id;

	public ShoppingListIdForm(Integer id) {
		super();
		this.id = id;
	}
	
	

}
