package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dao.CategoryDaoImpl;
import com.study.dao.ProductDaoImpl;
import com.study.entity.Category;
import com.study.entity.Product;

@Controller
public class CategoryController {
	@Autowired
	CategoryDaoImpl cdao;
	@Autowired
	ProductDaoImpl pdao;
	@RequestMapping("/category/{id}")
	public String category(Model model ,@PathVariable("id") int id) {
		Category cate = cdao.findById(id);
		List<Product> list = pdao.findByCategoryId(cate);
		int allProduct = pdao.pageSize();
		int sizePage = (int) Math.ceil(allProduct/8);
		model.addAttribute("size",sizePage);
		model.addAttribute("cate",cate);
		model.addAttribute("listProducts",list);
		return "categories/categories";
	}
}
