package com.demo.struts;

import java.util.EventListener;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.apache.struts2.tiles.StrutsTilesListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.demo.struts.service.ServiceFacade;

@SpringBootApplication(exclude = { FreeMarkerAutoConfiguration.class, RedisAutoConfiguration.class,RestClientAutoConfiguration.class })
public class Application extends SpringBootServletInitializer implements ApplicationRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired
	private ServiceFacade userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Started application at {}", "http://localhost:8080");
	}

	@Bean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new StrutsPrepareAndExecuteFilter());
		registration.setName("struts");
		registration.addUrlPatterns("/*");
		registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
		registration.setName("StrutsPrepareAndExecuteFilter");
		registration.setOrder(3);
		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<EventListener> strutsTilesListenerBean() {
		ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>();
		StrutsTilesListener strutsTilesListener = new StrutsTilesListener();
		registrationBean.setListener(strutsTilesListener);
		return registrationBean;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userService.putUsers();
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		servletContext.setInitParameter("org.apache.tiles.CONTAINER_FACTORY",
//		    "org.apache.struts2.tiles.StrutsTilesContainerFactory");
//		servletContext.setInitParameter("org.apache.tiles.impl.BasicTilesContainer.DEFINITIONS_CONFIG",
//		    "tiles.xml");
//	}
}