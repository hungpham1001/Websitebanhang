package com.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dao.ProductDaoImpl;


@Controller
public class HomeController {
	@Autowired
	ProductDaoImpl dao;
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("productImage ",dao.findAll());
		return "/";
	}
}
