package com.tunehub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.app.entities.PlayList;
import com.tunehub.app.entities.Songs;
import com.tunehub.app.services.PlayListServices;
import com.tunehub.app.services.SongService;

@Controller
public class PlayListController 
{
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListServices playListServices;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) 
	{
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playList) 
	{
		//updating playlist table
		playListServices.addPlayList(playList);
		System.out.println(playList);
		
		//updating song table
		List<Songs> songList = playList.getSongList();
		
		for(Songs s : songList)
		{
			s.getPlay_list().add(playList);
			//update song object in DB
			songService.updateSong(s);
		}
		return "adminhome";
	}
	
	@GetMapping("/viewAllPlayList")
	public String viewAllPlayList(Model model) 
	{
		
		List<PlayList> allPlaylists = playListServices.fetchAllPlayList();
		
		model.addAttribute("allPlaylists", allPlaylists);
		
		return "displayPlaylists";
	}
	
}
