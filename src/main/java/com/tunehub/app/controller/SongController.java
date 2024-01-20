package com.tunehub.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.tunehub.app.entities.Songs;
import com.tunehub.app.services.SongService;


@Controller
public class SongController 
{
	@Autowired
	SongService service;
	
	@PostMapping("/addsong")
	public String addSong (@ModelAttribute Songs song) 
	{
		boolean status = service.songExist(song);
		
		if(status == true)
		{			
			service.addSong(song);
			System.out.println("Song Added");
		}
		
		else
		{
			System.out.println("Song is alredy present");
		}
		
		return "newsong";
	}
	
	@GetMapping("/viewSongs")
	
	public String viewSongs(Model model) 
	{
		List<Songs> songList= service.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "display";
	}
	
}
