package com.tunehub.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.app.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
	public Users findByEmail(String email); 
}
