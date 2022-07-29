package com.generation.aod.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aod.model.entities.Race;

public interface RaceRepository extends JpaRepository<Race,Integer>
{
	default Race getRandomRace()
	{
		List<Race> races = findAll();
		
		return races.get((int)(Math.random()*races.size()));
	}
}
