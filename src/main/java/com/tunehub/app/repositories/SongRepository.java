package com.tunehub.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.app.entities.Songs;

public interface SongRepository extends JpaRepository<Songs, Integer>
{

	Songs findByName(String string);

}
