package com.generation.aod.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aod.model.entities.Profession;

public interface ProfessionRepository extends JpaRepository<Profession,Integer>
{
	List<Profession> findByLevel(int level);
	
	default Profession getRandomProfession(int level)
	{
		List<Profession> professions = findByLevel(level);
		
		return professions.get((int)(Math.random()*professions.size()));
	}
}
