package com.zhengwu.springcloudeurekaserver.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {



	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		// httpComponentsClientHttpRequestFactory.setConnectTimeout();
		// httpComponentsClientHttpRequestFactory.setReadTimeout();


		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);


		return 	restTemplate;
	}
}
