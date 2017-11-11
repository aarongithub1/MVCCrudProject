package com.skilldistillery.shopping.controllers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.shopping.data.ShoppingList;
import com.skilldistillery.shopping.data.ShoppingListDAO;

@Controller
@SessionAttributes("shoppingList")
public class ShoppingListController {
	
	@Autowired
	ShoppingListDAO dao;
	
	@ModelAttribute("shoppingList")
	public Set<String> newShoppingList() {
		return new LinkedHashSet<>();
	}
	
//	@RequestMapping(path = "home.do", method=RequestMethod.GET)
//	public String home() {
//		return "index";
//	}
	
	@RequestMapping(path="home.do", method=RequestMethod.GET)
	public ModelAndView IndexPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		ShoppingListIdForm f = new ShoppingListIdForm();
		mv.addObject("idForm", f);
		
		List<ShoppingList> allItems= dao.getShoppingList();
		mv.addObject("list", allItems);
		
		return mv;
	}
	
	@RequestMapping(path="getListItem.do", method=RequestMethod.POST)
	public ModelAndView getItemById(@RequestParam("listId") Integer id) {
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("listItem", dao.getListItemById(id));
		return mv;
				
	}
	
	@RequestMapping(path="getAllItem.do", method=RequestMethod.POST)
	public ModelAndView getWholeList(@ModelAttribute("shoppingList") Set<String> shoppingList) {
		ModelAndView mv = new ModelAndView("index");
//		String item = shoppingList.toString();
//		shoppingList.add(item);
		
		mv.addObject("shoppingList", dao.getShoppingList());
		return mv;
		
	}

}