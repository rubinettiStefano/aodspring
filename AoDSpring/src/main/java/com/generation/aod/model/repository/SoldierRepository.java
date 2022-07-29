package com.generation.aod.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aod.model.entities.Race;
import com.generation.aod.model.entities.Soldier;

public interface SoldierRepository extends JpaRepository<Soldier,Integer>
{

	List<Soldier> findByRace(Race race);
	
}
