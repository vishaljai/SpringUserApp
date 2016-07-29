package com.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class Hibernate {
	
	private DataSource createConnection(){
		
		 final BasicDataSource basicDataSource = new BasicDataSource();
		 basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 basicDataSource.setUrl("jdbc:mysql://localhost:3306/spring");
		 basicDataSource.setUsername("root");
		 basicDataSource.setPassword("root");
		 return basicDataSource;
	}
	
	private Properties setProperties(){
		
		final Properties properties = new Properties();
		
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.format_sql","true");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		final LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(createConnection());
		bean.setHibernateProperties(setProperties());
		bean.setPackagesToScan("com.entity");
		return bean;
	}
}
