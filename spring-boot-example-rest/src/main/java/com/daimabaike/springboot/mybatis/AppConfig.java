package com.daimabaike.springboot.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfig {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	public DataSource ds1() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	public DataSource secondDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/tcc?characterEncoding=UTF-8");
		dataSource.setUsername("tcc");
		dataSource.setPassword("a12345");
		return dataSource;
	}
	
	@Bean
	@Primary
	public DynamicDataSource cc() {
		return new DynamicDataSource(ds1(),secondDataSource());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(ds);
		
		return fb.getObject();
	}

}
