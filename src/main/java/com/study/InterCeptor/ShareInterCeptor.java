package com.study.InterCeptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.study.Services.CartServices;
import com.study.dao.CategoryDaoImpl;
import com.study.entity.Category;

@Component
public class ShareInterCeptor extends HandlerInterceptorAdapter{
	@Autowired
	CategoryDaoImpl cdao;
	@Autowired
	CartServices cart;
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		List<Category> list = cdao.findAll();
		request.setAttribute("categoryList", list);
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String backUri = request.getRequestURI();
		System.out.println(backUri+"before");
		if(backUri.equalsIgnoreCase("/error") || backUri.equals(null) || Pattern.matches("/stat\\w*", backUri)) {
			session.setAttribute("backUri", "/home");
		} else {
			session.setAttribute("backUri", backUri);
		}
		System.out.println(session.getAttribute("backUri")+"after");
		return true;
	}
}
