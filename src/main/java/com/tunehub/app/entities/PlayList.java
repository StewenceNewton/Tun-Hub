package com.tunehub.app.entities;


import java.util.List;

import jakarta.persistence.*;

@Entity
public class PlayList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	
	@ManyToMany
	List<Songs> songList;

	public PlayList() {
		super();
	}

	public PlayList(int id, String name, List<Songs> songList) {
		super();
		this.id = id;
		this.name = name;
		this.songList = songList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Songs> getSongList() {
		return songList;
	}

	public void setSongList(List<Songs> songList) {
		this.songList = songList;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", name=" + name + ", songList=" + songList + "]";
	}

	
}
