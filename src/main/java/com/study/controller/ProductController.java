package com.study.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.CookieService.CookieService;
import com.study.dao.ProductDaoImpl;
import com.study.entity.Product;

@Controller
public class ProductController {
	@Autowired
	CookieService cookie;
	@Autowired
	ProductDaoImpl pdao;
	@RequestMapping("/product/{id}")
	public String category(Model model ,@PathVariable("id") int id) {
		Product p = pdao.findById(id);
		List<Product> p1 = pdao.findTheSameProducts();
		model.addAttribute("list",p1);
		model.addAttribute("product",p);
		return "product/product";
	}
}
