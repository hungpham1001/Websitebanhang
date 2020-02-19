package com.study.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.Services.CartServices;
import com.study.entity.Customer;
import com.study.entity.Product;

@Controller
public class BasketController {
	@Autowired
	CartServices cart;
	@GetMapping("basket/basket-detail-guest")
	public String basketDetail(@Valid @ModelAttribute("user") Customer user,BindingResult result, Model model) {
		Collection<Product> list = cart.getAllItems();
		if(list.size()==0) {
			model.addAttribute("basketMessage","Please add items into basket!");
		} else {
			model.addAttribute("basketMessage","Basket List");
		}
		model.addAttribute("basketList", list);
		return "basket/basketDetailGuest";
	}
	@RequestMapping("basket/basket-detail-mem")
	public String basketDetailMem(Model model) {
		Collection<Product> list = cart.getAllItems();
		if(list.size()==0) {
			model.addAttribute("basketMessage","Please add items into basket!");
		} else {
			model.addAttribute("basketMessage","Basket List");
		}
		model.addAttribute("basketList", list);
		return "basket/basketDetailMem";
	}
	
	@ResponseBody
	@RequestMapping("/delete-item-basket/{id}")
	public Object[] deleteItem(@PathVariable("id") int id) {
		cart.remove(id);
		Object[] list = {cart.getCountOfCart(),cart.getTotal()};
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/minus-item-basket/{id}")
	public Object[] minusItem(@PathVariable("id") int id) {
		cart.minus(id);
		Object[] list = {cart.getCountOfCart(),cart.getTotal()};
		return list;
	}
	@ResponseBody
	@RequestMapping("/plus-item-basket/{id}")
	public Object[] plusItem(@PathVariable("id") int id) {
		cart.plus(id);
		Object[] list = {cart.getCountOfCart(),cart.getTotal()};
		return list;
	}
}
