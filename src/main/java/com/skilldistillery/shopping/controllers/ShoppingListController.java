package com.skilldistillery.shopping.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.shopping.data.ShoppingList;
import com.skilldistillery.shopping.data.ShoppingListDAO;

@SessionAttributes("shoppingList")
@Controller
public class ShoppingListController {
	
	@Autowired
	ShoppingListDAO dao;
	
	@ModelAttribute("shoppingList")
	public ShoppingList newShoppingList() {
		return new ShoppingList();
	}
	
//	@RequestMapping(path = "home.do", method=RequestMethod.GET)
//	public String home() {
//		return "index";
//	}

//----------------------------------------Display home page--------------------------------------------//
	//index page
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
	
	
//------------------------------------------- Create -------------------------------------------------//
	//add item to the list
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public String addItemToList(Model model) {
		ShoppingList s = new ShoppingList();
		model.addAttribute("shoppingList", s);
		
		return "add";
	}
	
	//doAdd
	@RequestMapping(path = "addItem.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid ShoppingList shoppingList, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addItemToList(shoppingList);
		
		mv.setViewName("added");
		
		return mv;
	}

	
//--------------------------------------------- Read -------------------------------------------------//
	
	@RequestMapping(path="getListItem.do", method=RequestMethod.POST)
	public ModelAndView getItemByIdForm(@Valid @ModelAttribute("idForm")ShoppingListIdForm f, Errors e) {
		ModelAndView mv = new ModelAndView("index");
		
		if(e.hasErrors()) {
			// go to the same page or an error page
			mv.setViewName("index");
			return mv;
		}
		
		mv.setViewName("info");
		
		ShoppingList shoppingList = dao.getListItemById(f.getId());
		mv.addObject("ShoppingList", shoppingList);
		return mv;
	}
	
	// pass id through href link
	@RequestMapping(path="info.do")
	public ModelAndView getItemById(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("info");
		
		ShoppingList item = dao.getListItemById(id);
		mv.addObject("shoppingList", item);
		
		return mv;
	}
	
	
//--------------------------------------------- Update -------------------------------------------------//
	
	@RequestMapping(path="update.do")
	public ModelAndView updateItemInList(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("update");
		
		ShoppingList item = dao.getListItemById(id);
		mv.addObject("shoppingList", item);		

		return mv;
	}
	
	// doUpdate
		@RequestMapping(path = "updateItem.do", method=RequestMethod.POST)
		public ModelAndView doUpdate(@Valid ShoppingList shoppingList, Errors e) {
			ModelAndView mv = new ModelAndView();
			if(e.hasErrors()) {
				mv.setViewName("update");
				return mv;
			}
			dao.updateShoppingList(shoppingList);
			
			mv.setViewName("added");
			
			return mv;
		}
	
//--------------------------------------------- Delete -------------------------------------------------//
	
	
	
}



//	@RequestMapping(path="getListItem.do", method=RequestMethod.POST)
//	public ModelAndView getItemById(@RequestParam("listId") Integer id) {
//		ModelAndView mv = new ModelAndView("index");
//		
//		mv.addObject("listItem", dao.getListItemById(id));
//		return mv;
//				
//	}
	
//	@RequestMapping(path="getAllItems.do", method=RequestMethod.POST)
//	public ModelAndView getWholeList(@ModelAttribute("shoppingList") Set<String> shoppingList) {
//		ModelAndView mv = new ModelAndView("index");
////		String item = shoppingList.toString();
////		shoppingList.add(item);
//		
//		mv.addObject("shoppingList", dao.getShoppingList());
//		return mv;
//		
//	}
