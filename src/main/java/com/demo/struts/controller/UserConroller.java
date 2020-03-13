package com.demo.struts.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.struts.model.User;
import com.demo.struts.service.ServiceFacade;

@RestController
public class UserConroller {

	@Autowired
	private ServiceFacade userService;

	@GetMapping(value = "/api/users", produces = { APPLICATION_JSON_VALUE, TEXT_PLAIN_VALUE })
	public List<User> getUsers() throws Exception {
		return userService.retrieveUsers();
	}
}
