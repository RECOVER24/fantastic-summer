package org.nhnnext.recover24.fantastic_summer_crawler.config;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInitializer implements WebApplicationInitializer {

	private final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	
	@Override
	public void onStartup(ServletContext servletContext) {
		
		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

	}

}