package com.daimabaike.mybatis;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class) ;
	@Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
  //      factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        
        
//        factory.setBufferRequestBody(bufferRequestBody);
//        factory.sett
        return factory;
    }

    @Bean("a")
    public RestTemplate restTemplate2(ClientHttpRequestFactory factory){
//    	System.out.println(123);
    	RestTemplate rt = new RestTemplate(factory);
//    	rt.setMessageConverters(messageConverters);
    	
    	logger.info(rt.getMessageConverters().toString());
        return rt;
    }

    @Bean //("b")
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
//    	System.out.println(456);
    	RestTemplate rt = new RestTemplate(factory);
    	
//    	List<HttpMessageConverter<String>> as = new ArrayList<HttpMessageConverter<String>>();
    	List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    	
    	messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    	rt.setMessageConverters(messageConverters);
    	
    	logger.info(rt.getMessageConverters().toString());
        return rt;
    }
    
}
