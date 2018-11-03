package com.daimabaike.springboot.mybatis;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.stereotype.Component;

//import com.daimabaike.springboot.mybatis.util.SpringUtils;

//@Component
//@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

	public static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	public static void set(String ds) {
		contextHolder.set(ds);
	}

	public static void clear() {
		contextHolder.remove();
	}

	public DynamicDataSource(DataSource ds1,DataSource ds2) {//@Qualifier("Datasource1") DataSource ds1,@Qualifier("secondDatasource") DataSource ds2
		
//		System.out.println(map);
		

		Map<Object, Object> map = new HashMap<>();
//		DataSource ds1 = SpringUtils.getBean("Datasource1", DataSource.class);
//		DataSource ds2 = SpringUtils.getBean("secondDatasource", DataSource.class);
		
		map.put("ds1", ds1);
		map.put("ds2", ds2);
		this.setTargetDataSources(map);
		this.setDefaultTargetDataSource(ds1);
		
	}

//	public void afterPropertiesSet(){
//		
//		Map<Object, Object> map = new HashMap<>();
//		DataSource ds1 = SpringUtils.getBean("Datasource1", DataSource.class);
//		DataSource ds2 = SpringUtils.getBean("secondDatasource", DataSource.class);
//		
//		map.put("ds1", ds1);
//		map.put("ds2", ds2);
//		this.setTargetDataSources(map);
//		this.setDefaultTargetDataSource(ds1);
//		
		
//		super.afterPropertiesSet();
//	}
	
	@Override
	public String determineCurrentLookupKey() {
		
		System.out.println("contextHolder.get()="+contextHolder.get());
		return contextHolder.get();
	}

}
