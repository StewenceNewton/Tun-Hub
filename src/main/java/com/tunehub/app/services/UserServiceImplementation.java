package com.tunehub.app.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entities.Songs;
import com.tunehub.app.entities.Users;
import com.tunehub.app.repositories.SongRepository;
import com.tunehub.app.repositories.UsersRepository;

@Service
public class UserServiceImplementation implements UserServices{

	@Autowired
	UsersRepository repo;
	
	@Autowired
	SongRepository songRepo;
	
	@Override
	public String addUser(Users us) 
	{
		repo.save(us);
		return "User added";
	}
	
	public boolean emaliExists(String email)
	{
		if(repo.findByEmail(email) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateuser(String email, String password) 
	{
		Users us = repo.findByEmail(email);
		
		String db_pass = us.getPassword();
		
		if(password.equals(db_pass))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String getRole(String email) 
	{
		Users us = repo.findByEmail(email);
		return us.getRole();
	}

	@Override
	public Users getUser(String email) 
	{
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) 
	{
		repo.save(user);
	}

	@Override
	public boolean getPremium(String email) 
	{
		return repo.findByEmail(email).isPremium();
	}

	@Override
	public List<Songs> fetchAllSongs() 
	{
		return songRepo.findAll();
	}

}
