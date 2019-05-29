package com.daimabaike.biz.common.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import okhttp3.OkHttpClient;

@Configuration
public class RestTemplateConfig {

	Logger logger = LoggerFactory.getLogger(FooConfig.class);

	@Bean
	@Primary
	public RestTemplate restTemplate(ClientHttpRequestFactory factory) {

		// HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
		// public boolean verify(String hostname, SSLSession session) {
		// System.out.println("HostnameVerifier.verify call");
		// return true;
		// }
		// });
		// SSLContext context = SSLContext.getInstance("TLS");
		// context.init(null, new X509TrustManager[] { new X509TrustManager() {
		// public void checkClientTrusted(X509Certificate[] chain, String authType)
		// throws CertificateException {
		// System.out.println("X509TrustManager.checkClientTrusted call");
		// }
		//
		// public void checkServerTrusted(X509Certificate[] chain, String authType)
		// throws CertificateException {
		// System.out.println("X509TrustManager.checkServerTrusted call");
		// }
		//
		// public X509Certificate[] getAcceptedIssuers() {
		// System.out.println("X509TrustManager.getAcceptedIssuers call");
		// return new X509Certificate[0];
		// }
		// } }, new SecureRandom());
		// HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

		RestTemplate restTemplate = new RestTemplate();
////		factory
		ClientHttpRequestInterceptor inter = new ClientHttpRequestInterceptor() {

			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {

				ClientHttpResponse resp = execution.execute(request, body);

				return resp;
			}

		};
		restTemplate.getInterceptors().add(inter);

		logger.info("restTemplate.getInterceptors()={}", restTemplate.getInterceptors().toString());

		return restTemplate;

	}

//	@Bean
//	@Primary
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		// ms
		factory.setReadTimeout(2000);
		factory.setConnectTimeout(15000);

		return factory;
	}

	@Bean("ok3RestTemplate")
	public RestTemplate ok3RestTemplate(ClientHttpRequestFactory factory) {

		RestTemplate restTemplate = new RestTemplate(factory);

		ClientHttpRequestInterceptor inter = new ClientHttpRequestInterceptor() {

			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {

				ClientHttpResponse resp = execution.execute(request, body);

				return resp;
			}

		};
		restTemplate.getInterceptors().add(inter);
//		restTemplate.set
		return restTemplate;
	}

	@Bean("ok3")
	public ClientHttpRequestFactory ok3ClientHttpRequestFactory() {

		OkHttpClient OkHttpClient=new OkHttpClient();
		OkHttpClient.connectionPool().connectionCount();
		OkHttp3ClientHttpRequestFactory okf = new OkHttp3ClientHttpRequestFactory();
		okf.setConnectTimeout(1000);
		okf.setReadTimeout(3000);
		okf.setWriteTimeout(3000);
		
//		okf.
		
		return okf;
	}

}
