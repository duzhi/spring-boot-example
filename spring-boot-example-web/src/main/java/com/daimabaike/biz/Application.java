package com.daimabaike.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableAutoConfiguration 与 @SpringBootApplication区别

//spring通常建议我们将main方法所在的类放到一个root包下，@EnableAutoConfiguration（开启自动配置）注解通常都放到main所在类的上面，这样@EnableAutoConfiguration可以从逐层的往下搜索各个加注解的类，例如，你正在编写一个JPA程序（如果你的pom里进行了配置的话），spring会自动去搜索加了@Entity注解的类，并进行调用。

//一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值。

@SpringBootApplication
public class Application {

	static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}