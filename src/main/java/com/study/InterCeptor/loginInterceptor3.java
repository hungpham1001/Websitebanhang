package com.study.InterCeptor;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.study.CookieService.CookieService;
import com.study.dao.CustomerDaoImpl;
import com.study.entity.Customer;

@Component
public class loginInterceptor3 extends HandlerInterceptorAdapter {
	@Autowired
	HttpServletRequest request;
	@Autowired
	CookieService ck;
	@Autowired
	CustomerDaoImpl cus;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession session = request.getSession();
		Cookie cookie = ck.read("accrmb");
		Cookie cookie1 = ck.read("accrmb1");
		if(cookie!=null) {
			Customer cust = cus.findById(cookie.getValue());
			if(cust!=null&&cust.getPassword().equals(cookie1.getValue())) {
				session.setAttribute("user", cust);
			}
		}
		return true;
	}
}

