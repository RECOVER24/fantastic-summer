package org.nhnnext.recover24.fantastic_summer_crawler.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableCaching
@EnableJpaRepositories(basePackages = {"**.domain", "**.repository"})
@PropertySources({
	@PropertySource(value = "classpath:database/config.xml"),
})
@EnableTransactionManagement
public class PersistenceConfig {
	
	@Value("classpath:ehcache.xml")
	private Resource ehcache;

	private static final String PERSISTENCE_PACKAGE = "**.domain";
	private static final String HIBERNATE_CACHE_USE_QUERY_CACHE = "hibernate.cache.use_query_cache";
	private static final String HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";
	private static final String HIBERNATE_CACHE_REGION_FACTORY_CLASS = "hibernate.cache.region.factory_class";
	
	private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String HIBERNATE_EJB_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_GENERATE_STATISTICS = "hibernate.generate_statistics";

	private static final String DATABASE_PASSWORD = "database.password";
	private static final String DATABASE_USERNAME = "database.username";
	private static final String DATABASE_URL = "database.url";
	private static final String DATABASE_DRIVER_CLASS_NAME = "database.driverClassName";
	

	@javax.annotation.Resource
	private Environment env;

	@Bean
	DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER_CLASS_NAME));
		dataSource.setUrl(env.getRequiredProperty(DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(PERSISTENCE_PACKAGE);

		Properties jpaProperties = new Properties();
		jpaProperties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
		jpaProperties.put(HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));
		jpaProperties.put(HIBERNATE_EJB_NAMING_STRATEGY, env.getRequiredProperty(HIBERNATE_EJB_NAMING_STRATEGY));
		jpaProperties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
		jpaProperties.put(HIBERNATE_FORMAT_SQL, env.getRequiredProperty(HIBERNATE_FORMAT_SQL));
		jpaProperties.put(HIBERNATE_GENERATE_STATISTICS, env.getRequiredProperty(HIBERNATE_GENERATE_STATISTICS));
		
		jpaProperties.put(HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE, env.getRequiredProperty(HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
		jpaProperties.put(HIBERNATE_CACHE_REGION_FACTORY_CLASS, env.getRequiredProperty(HIBERNATE_CACHE_REGION_FACTORY_CLASS));
		jpaProperties.put(HIBERNATE_CACHE_USE_QUERY_CACHE, env.getRequiredProperty(HIBERNATE_CACHE_USE_QUERY_CACHE));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	@Bean
	LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
//	@Bean
//	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//		dataSourceInitializer.setDataSource(dataSource);
//		
//		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//		databasePopulator.addScript(securityInfo);
//		dataSourceInitializer.setDatabasePopulator(databasePopulator);
//		dataSourceInitializer.setEnabled(true);
//		
//		return dataSourceInitializer;
//	}
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
 
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(ehcache);
		cmfb.setShared(true);
		return cmfb;
	}

}