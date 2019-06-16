package com.daimabaikeuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
