package com.study.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.CookieService.CookieService;
import com.study.Services.CartServices;

@Controller
public class CookieController {
	@Autowired
	CartServices cart;
	@Autowired
	CookieService cookie;
	@Autowired
	HttpSession session;
	@ResponseBody
	@RequestMapping("/add-favo/{id}")
	public String addFavo(@PathVariable("id") Integer id) {
		Cookie ck = cookie.read("favo");
		String value = id.toString();
		if(ck!=null) {
			value = ck.getValue();
			if(!value.contains(id.toString())) {
				value += ","+id.toString();
			} else {
				return "Đã có sẵn trong mục ưa thích";
			}
		}
		ck = cookie.create("favo", value, 30);
		return "Đã thêm vào mục ưa thích";
	}
	
	@ResponseBody
	@RequestMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable("id") int id) {
		cart.add(id);
		Integer ids = cart.getCountOfCart();
		return ids.toString();
	}
}
