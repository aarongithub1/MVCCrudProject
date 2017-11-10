package com.skilldistillery.shopping.controllers;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.shopping.data.ShoppingListDAO;

@Controller
@SessionAttributes({"itemList", "currentItem"})
public class ShoppingListController {
	
	@Autowired
	ShoppingListDAO dao;
	
	@ModelAttribute("shoppingList")
	public Set<String> newShoppingList() {
		return new LinkedHashSet<>();
	}
	
	@RequestMapping(path = "home.do", method=RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(path="getListItem.do", method=RequestMethod.POST, params="listId")
	public ModelAndView getGiraffeById(@RequestParam("listId") Integer id,
								@ModelAttribute("shoppingList") Set<String> shoppingList) {
		ModelAndView mv = new ModelAndView("index");
		
//		ShoppingList item = dao.getListItemById(id);
		
		mv.addObject("shoppingList", dao.getListItemById(id));
		mv.addObject("shoppingList", dao.getShoppingList());
		return mv;
				
	}

}