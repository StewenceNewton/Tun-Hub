package com.tunehub.app.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Songs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	
	@ManyToMany
	List<PlayList> Play_list;

	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Songs(int id, String name, String artist, String genre, String link, List<PlayList> play_list) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		Play_list = play_list;
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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<PlayList> getPlay_list() {
		return Play_list;
	}

	public void setPlay_list(List<PlayList> play_list) {
		Play_list = play_list;
	}

	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ "]";
	}
	
}
