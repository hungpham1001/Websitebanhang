package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dao.ProductDaoImpl;
import com.study.entity.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDaoImpl dao;
	@RequestMapping(path = {"/","/home"})
	public String home(Model model) {
		List<Product> list = dao.findTop10();
		model.addAttribute("productImage", list);
		return "body/index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "body/about";
	}
}
