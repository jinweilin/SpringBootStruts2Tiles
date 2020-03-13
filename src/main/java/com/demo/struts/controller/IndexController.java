package com.demo.struts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.struts.model.User;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "redirect:/index.jsp";
	}

	@GetMapping("/mvcview")
	public ModelAndView mvcview() {
		User user = new User(10,"test1","test2","30","F");
		ModelAndView view = new ModelAndView("mvcjspview");
		view.addObject("user", user);
		return view;
	}
}
