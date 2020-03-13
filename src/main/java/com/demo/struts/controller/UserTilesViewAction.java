package com.demo.struts.controller;

import org.springframework.stereotype.Component;

import com.demo.struts.model.User;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class UserTilesViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user ;
	@Override
	public String execute() throws Exception {
		user = new User(10,"test1","test2","30","F");
		return "usertilesview";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
