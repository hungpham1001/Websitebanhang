package com.study.InterCeptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class loginInterceptor2 extends HandlerInterceptorAdapter {
	@Autowired
	HttpServletRequest request;
	HttpServletResponse response;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			 response.sendRedirect((String)  session.getAttribute("backUri"));
			 return false;
		}
		return true;
	}
}

