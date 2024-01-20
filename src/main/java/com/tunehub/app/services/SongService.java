package com.tunehub.app.services;

import java.util.List;

import com.tunehub.app.entities.Songs;

public interface SongService 
{
	public void addSong(Songs song);

	public List<Songs> fetchAllSongs();

	public boolean songExist(Songs song);

	public void updateSong(Songs s);
}
