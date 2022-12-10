package com.xoriant.bankingapplication.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
 * connection with database using jdbc driver
 */
@Configuration
@ComponentScan(basePackages = {"com.xoriant.bankingapplication.dao","com.xoriant.bankingapplication.daoimpl","com.xoriant.bankingapplication"})
public class SpringRootConfig {
	
	@Bean
	public BasicDataSource getDataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/banking");
		return ds;
	}

}
