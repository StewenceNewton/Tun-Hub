package com.tunehub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.app.entities.Songs;
import com.tunehub.app.entities.Users;
import com.tunehub.app.services.UserServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController 
{
	@Autowired
	UserServices service;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users us)
	{
		boolean emailStatus = service.emaliExists(us.getEmail());
		
		if(emailStatus == false)
		{
			if(us.getRole().equalsIgnoreCase("admin"))
			{
				us.setPremium(true);
				service.addUser(us);
				System.out.println("User added");
			}
			
			else
			{
				service.addUser(us);
				System.out.println("User added");
			}

		}
		
		else
		{
			System.out.println("User present");
		}
		return "index";
	}
	
	
	@PostMapping("/validate")
	public String validation(@RequestParam("email")String email,@RequestParam("password")String password,
			HttpSession session, Model model)
	{
		if(service.validateuser(email,password)== true)
		{
			String role = service.getRole(email);
			boolean premiumStatus = service.getPremium(email);
			
			session.setAttribute("email", email);
			
			if(role.equalsIgnoreCase("admin"))
			{
				return "adminhome";
			}
			else if(role.equalsIgnoreCase("user") && premiumStatus == true)
			{
				List<Songs> songList= service.fetchAllSongs();
				model.addAttribute("songs",songList);
				return "display";
			}
			
			else
			{
				return "customerhome";
			}
		}
		
		else
		{
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "login";
	}
	
}
