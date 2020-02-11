package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.study.InterCeptor.ShareInterCeptor;
import com.study.InterCeptor.loginInterceptor;
import com.study.InterCeptor.loginInterceptor2;
import com.study.InterCeptor.loginInterceptor3;

@Configuration
public class InterCeptorConfig implements WebMvcConfigurer {
	@Autowired
	ShareInterCeptor share;
	@Autowired
	loginInterceptor login;
	@Autowired
	loginInterceptor2 login2;
	@Autowired
	loginInterceptor3 login3;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(share).addPathPatterns("/**").excludePathPatterns("/account/login","/account/logout");
		registry.addInterceptor(login).addPathPatterns("/account/edit","/account/logout","/order/**",
				"/basket/basket-detail-mem").excludePathPatterns("/order/success-guest","/order/success");
		registry.addInterceptor(login2).addPathPatterns("/account/login");
		registry.addInterceptor(login3).addPathPatterns("/**");
	}
}
