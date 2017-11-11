package com.skilldistillery.shopping.controllers;

import javax.validation.constraints.NotNull;

public class ShoppingListIdForm {
	@NotNull
	private Integer id;

	public ShoppingListIdForm() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
