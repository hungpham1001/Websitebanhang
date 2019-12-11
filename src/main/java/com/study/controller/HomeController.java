package com.study.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dao.ProductDaoImpl2;
import com.study.entity.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDaoImpl2 dao;
	@RequestMapping("/")
	public String home(Model model) {
		List<Product> list = dao.findAll();
		model.addAttribute("listhotItem",list);
		return "/";
	}
}
