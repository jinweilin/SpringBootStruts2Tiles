package com.demo.struts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false).ignoreAcceptHeader(true)
		    .defaultContentType(MediaType.APPLICATION_JSON)
		    .mediaType("xml", MediaType.APPLICATION_XML)
		    .mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("rest", MediaType.TEXT_HTML);
	}
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/** 设置视图路径的前缀 */
		resolver.setPrefix("/WEB-INF/jsp/");
		/** 设置视图路径的后缀 */
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
