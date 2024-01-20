package com.tunehub.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entities.Songs;
import com.tunehub.app.repositories.SongRepository;

@Service
public class SongServiceImplimintation implements SongService
{
	@Autowired
	SongRepository repo;

	@Override
	public void addSong(Songs song) 
	{
		repo.save(song);
	}

	@Override
	public List<Songs> fetchAllSongs() 
	{
		return repo.findAll();
	}

	@Override
	public boolean songExist(Songs song) 
	{
		if (repo.findByName(song.getName()) == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public void updateSong(Songs s) 
	{
		repo.save(s);
	}
}
