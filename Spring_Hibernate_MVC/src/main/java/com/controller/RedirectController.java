package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping(path="/")
	public String register(){
		return "Register";
	}

	@RequestMapping(path="/loginPage")
	public String login(){
		return "Login";
	}
	
	@RequestMapping(path="/updatePage")
	public String update(){
		return "Update";
	}
	
	@RequestMapping(path="/deletePage")
	public String delete(){
		return "Delete";
	}
	
}
