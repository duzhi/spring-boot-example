package com.daimabaike.springboot.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfig {

	//@Bean(name = "Datasource1")
	// @ConfigurationProperties(prefix = "spring.datasource")
	public DataSource ds1() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/study?characterEncoding=UTF-8");
		dataSource.setUsername("study");
		dataSource.setPassword("study#9527#DUzhi");
		return dataSource;
	}

	//@Bean(name = "secondDatasource")
	// @ConfigurationProperties(prefix = "spring.datasource2")
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
//	@Primary
	public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		System.out.println("ds="+ds);
		fb.setDataSource(ds);
		
		
		return fb.getObject();
	}

}
