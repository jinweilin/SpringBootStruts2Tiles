package com.demo.struts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.struts.security.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @Override
	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
	// auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
	// withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER");
	// }
	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		    .antMatchers("/", "/js/**", "/images/**","/actuator/**")
		    .permitAll().anyRequest().hasRole("USER").and()
		    .formLogin().loginPage("/index.jsp")
		    .failureUrl("/index.jsp?error=1").loginProcessingUrl("/j_spring_security_check").permitAll().and().logout()
		    .logoutSuccessUrl("/users");
	}


}
