package com.tunehub.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entities.PlayList;
import com.tunehub.app.repositories.PlayListRepository;

@Service
public class PlayListServiceImplemintation implements PlayListServices
{
	@Autowired
	PlayListRepository playListRepo;

	@Override
	public void addPlayList(PlayList playList) 
	{
		playListRepo.save(playList);
	}

	@Override
	public List<PlayList> fetchAllPlayList() 
	{
		return playListRepo.findAll();
	}

}
