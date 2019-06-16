package com.daimabaike.console.biz.component;

import java.net.URLEncoder;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class DiffSetCLR {

	public DiffSetCLR(){
		System.out.println("DiffSetCLR()");
	}
	public static void main(String... args) throws Exception {
		
		String str = "HCbG3xNE3vzhO+u7qCUL1jS5hsu2n5r2cFhnTrtyDAE=";
		System.out.println(	URLEncoder.encode(str, "utf-8"));
		
		AntPathMatcher m = new AntPathMatcher();
		
		System.out.println(m.match("/ff/**", "/ff"));
		System.out.println(m.match("/ff/**", "/ff/"));
		System.out.println(m.match("/ff/**", "/ff/1"));
		System.out.println(m.match("/ff/**", "/ff/1/"));
		
		System.out.println(m.match("/ff/*", "/ff"));
		System.out.println(m.match("/ff/*", "/ff/"));
		System.out.println(m.match("/ff/*", "/ff/1"));
		System.out.println(m.match("/ff/*", "/ff/1/"));
		
		System.out.println(m.match("/ff/.", "/ff"));
		System.out.println(m.match("/ff/.", "/ff/."));
		System.out.println(m.match("/ff/.", "/ff/12"));
		System.out.println(m.match("/ff/.", "/ff/13/"));
		
		System.out.println(m.match("/ff/?*", "/ff"));
		System.out.println(m.match("/ff/?*", "/ff/"));
		System.out.println(m.match("/ff/?*", "/ff/11"));
		System.out.println(m.match("/ff/?*", "/ff/212/"));
		
		
//		System.out.println(m.)
		
	//	System.out.println(d);
		
//		String data="sdsd";
//		String secret="sdsdsd";
//
//		byte[] bytes = null;
//		try {
//			SecretKey secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacMD5");//HmacSHA256
//			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
//			mac.init(secretKey);
//			bytes = mac.doFinal(data.getBytes("utf-8"));
//		} catch (GeneralSecurityException gse) {
//			throw new IOException(gse.toString());
//		}
//
//
//		StringBuilder sign = new StringBuilder();
//		for (int i = 0; i < bytes.length; i++) {
//			String hex = Integer.toHexString(bytes[i] & 0xFF);
//			if (hex.length() == 1) {
//				sign.append("0");
//			}
//			sign.append(hex.toUpperCase());
//		}
//		System.out.println(sign.toString());

	
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("init");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("destroy");
	}
	
}
