package com.demo.struts;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//public class SecurityConfig {

	// authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
		withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER");
	}
	
	// authorication
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
				.and().formLogin().loginPage("/login.jsp")
				.failureUrl("/login.jsp?error=1").loginProcessingUrl("/j_spring_security_check")
				.permitAll().and().logout()
				.logoutSuccessUrl("/users");

	}

}
