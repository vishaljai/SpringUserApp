package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.servie.UserService;

@Controller
public class UserController {
	
	private final static ModelAndView mv = new ModelAndView();
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public ModelAndView addUser(@RequestParam String username, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String password){
		
		User user = userService.addUser(username,firstName,lastName,password);
		
		if(user != null){
			mv.setViewName("Home");
			mv.addObject("user", user);
		}
		
		else{
			mv.setViewName("Error");
			mv.addObject("error","Some error ocured");
		}
		
		return mv;
		
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam int id, @RequestParam String password){
		
		User user = userService.loginUser(id, password);
		
		if(user != null){
			mv.setViewName("Home");
			mv.addObject("user",user);
		}
		else{
			mv.setViewName("Error");
			mv.addObject("error", "Invalid username or password");
		}
		
		return mv;
	}

}
