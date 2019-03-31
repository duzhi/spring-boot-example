package com.daimabaike.biz.common.config;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) throws Exception {

//		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//			public boolean verify(String hostname, SSLSession session) {
//				System.out.println("HostnameVerifier.verify call");
//				return true;
//			}
//		});
//		SSLContext context = SSLContext.getInstance("TLS");
//		context.init(null, new X509TrustManager[] { new X509TrustManager() {
//			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//				System.out.println("X509TrustManager.checkClientTrusted call");
//			}
//
//			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//				System.out.println("X509TrustManager.checkServerTrusted call");
//			}
//
//			public X509Certificate[] getAcceptedIssuers() {
//				System.out.println("X509TrustManager.getAcceptedIssuers call");
//				return new X509Certificate[0];
//			}
//		} }, new SecureRandom());
//		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

		System.out.println("getFollowRedirects: " + HttpsURLConnection.getFollowRedirects());
		
        RestTemplate r = new RestTemplate();
        
        r.setRequestFactory(factory);
        
        r.setErrorHandler(new ResponseErrorHandler() {
			
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}
			
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				
			}
		});
        
        return r;
        
        
    }
 
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(2000);//ms
        factory.setConnectTimeout(15000);//ms
        

//        OkHttp3ClientHttpRequestFactory okf = new OkHttp3ClientHttpRequestFactory();
//        okf.setConnectTimeout(1000);
//        okf.setReadTimeout(3000);
//        okf.setWriteTimeout(3000);
        
        
        return factory;
    }

}
