package com.tunehub.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavIgationController 
{
	@GetMapping("/login")
	public String login()
	{		
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration()
	{		
		return "register";
	}
	
	@GetMapping("/newsong")
	public String newsong() 
	{
		return "newsong";
	}
	
	
}
