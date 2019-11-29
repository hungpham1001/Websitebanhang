package com.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class tilesconfig {
	@Bean("ViewResolver")
	public ViewResolver getViewResolver() {
		UrlBasedViewResolver view = new UrlBasedViewResolver();
		view.setViewClass(TilesView.class);
		return view;
	}
	@Bean("TilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesconfig = new TilesConfigurer();
		tilesconfig.setDefinitions("/WEB-INF/tiles.xml");
		return tilesconfig;
	}
	
}
