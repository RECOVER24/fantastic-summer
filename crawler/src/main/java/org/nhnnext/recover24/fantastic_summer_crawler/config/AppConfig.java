package org.nhnnext.recover24.fantastic_summer_crawler.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceConfig.class })
@ComponentScan(
		basePackages = {
				"**.service",
		},
		excludeFilters={
				@Filter(type = FilterType.ANNOTATION, value = Configuration.class)
		}
)
public class AppConfig {

}