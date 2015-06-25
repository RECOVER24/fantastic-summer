package org.nhnnext.recover24.fantastic_summer_crawler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import({ PersistenceConfig.class })
@ComponentScan(
		basePackages = {
				"**.service",
				"**.controller",
		},
		excludeFilters={
				@Filter(type = FilterType.ANNOTATION, value = Configuration.class)
		}
)
public class AppConfig extends WebMvcConfigurerAdapter{

	@Bean
	 public ViewResolver configureViewResolver() {
	     InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
	     viewResolve.setPrefix("/WEB-INF/views/");
	     viewResolve.setSuffix(".jsp");

	     return viewResolve;
	 }
}