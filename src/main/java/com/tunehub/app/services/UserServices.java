package com.tunehub.app.services;

import java.util.List;

import com.tunehub.app.entities.Songs;
import com.tunehub.app.entities.Users;

public interface UserServices 
{
	public String addUser(Users us);
	public boolean emaliExists(String email);
	public boolean validateuser(String email,String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
	public boolean getPremium(String email);
	public List<Songs> fetchAllSongs();
}
