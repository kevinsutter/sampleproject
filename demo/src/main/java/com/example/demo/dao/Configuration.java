package com.example.demo.dao;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestOperations restOperations() {
		return new RestTemplateBuilder().messageConverters(new MappingJackson2HttpMessageConverter(
				new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES))).additionalInterceptors(new ClientHttpRequestInterceptor() {
					
					@Override
					public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
							throws IOException {
						request.getHeaders().set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			            return execution.execute(request, body);
					}
				}).build();
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
