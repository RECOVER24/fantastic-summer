package org.nhnnext.recover24.fantastic_summer_crawler.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	
	private static final String ALL = "/*";
	private static final String ROOT = "/";
	private static final String CRAWLER = "crawler";
	private static final String UTF8 = "UTF-8";
	private static final String TRUE = "true";

	private final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	
	@Override
	public void onStartup(ServletContext servletContext) {
		// spring application context
//		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// spring application context의 dispatcher servlet
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//		dispatcherContext.register(WebConfig.class);

		// dispatcher servlet 등록
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(CRAWLER, new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(ROOT);
		dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", TRUE);

		// filter
		FilterRegistration charEncodingfilterReg = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", UTF8);
		charEncodingfilterReg.setInitParameter("forceEncoding", TRUE);
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, ALL);
		
	}

}