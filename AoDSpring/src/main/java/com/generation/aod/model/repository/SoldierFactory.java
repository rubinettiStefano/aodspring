package com.generation.aod.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generation.aod.model.entities.Soldier;

@Component
public class SoldierFactory
{
	@Autowired
	RaceRepository raceRepository;
	
	@Autowired
	ProfessionRepository professionRepository;
	
	
	
	
	public SoldierFactory() {}
	
	// soldato comune
	public Soldier make(int id)
	{
		// Soldato COMPLETAMENTE CASUALE. 
		Soldier soldier = new Soldier();
		soldier.setId(id);
		soldier.setRace(raceRepository.getRandomRace());
		soldier.setRandomGender();
		soldier.setRandomName();
		soldier.setProfession(professionRepository.getRandomProfession(0));
		soldier.setRandomSalary(); // usa la professione	
		soldier.setRandomAge(); // età'da calcolare compresa fra 18 e il 75 percento della eta' massima per la razza
		soldier.setRandomWeight();  // +/- 20% rispetto alla media razziale
		soldier.setRandomHeight();  // +/- 20% rispetto alla media razziale
		
		return soldier;
	}
	
	public List<Soldier> makeMany(int minId, int maxId)
	{
		List<Soldier> res = new ArrayList<Soldier>();
		for(int i=minId;i<=maxId;i++)
			res.add(make(i));
		return res;
		
	}
	
	
}
