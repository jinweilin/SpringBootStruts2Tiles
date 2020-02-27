package com.demo.struts.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		if (name.equalsIgnoreCase("user") && password.equals("user")) {// replace your custom code here for custom
		                                                               // authentication
			SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
			List<GrantedAuthority> permissions = new ArrayList<>();
			permissions.add(grantedAuthority);
			final UserDetails principal = new User(name, password, permissions);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, permissions);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}
}
