package com.daimabaike.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringbootApplication 等于 @EnableAutoConfiguration、@Configuration 和 @ComponentScan 并具有他们的默认属性值。
// 通常将main方法所在的类放到一个root包下，@EnableAutoConfiguration（开启自动配置）注解通常都放到main所在类的上面，
// 这样 @EnableAutoConfiguration 可以从同层和下层去搜索各个加注解的类。

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}