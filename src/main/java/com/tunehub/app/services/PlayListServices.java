package com.tunehub.app.services;


import java.util.List;

import com.tunehub.app.entities.PlayList;

public interface PlayListServices
{

	public void addPlayList(PlayList playList);

	public List<PlayList> fetchAllPlayList();
	
}
