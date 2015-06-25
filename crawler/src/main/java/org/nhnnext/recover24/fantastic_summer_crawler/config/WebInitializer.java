package org.nhnnext.recover24.fantastic_summer_crawler.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	private final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	
	private static final String ALL = "/*";
	private static final String ROOT = "/";
	private static final String MARKER = "marker";
	private static final String UTF8 = "UTF-8";
	private static final String TRUE = "true";

	
	@Override
	public void onStartup(ServletContext servletContext) {
		
		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		// spring application context의 dispatcher servlet
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(AppConfig.class);

		// dispatcher servlet 등록
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(ROOT);
		dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

}