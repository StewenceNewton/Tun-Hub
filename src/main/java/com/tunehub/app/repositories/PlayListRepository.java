package com.tunehub.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.app.entities.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer>
{
	
}
