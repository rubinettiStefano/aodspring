package com.generation.aod.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aod.model.entities.Profession;
import com.generation.aod.model.entities.Race;
import com.generation.aod.model.repository.ProfessionRepository;
import com.generation.aod.model.repository.RaceRepository;

@RestController
public class Initialization
{

	@Autowired
	ProfessionRepository repoP;
	@Autowired
	RaceRepository repoR;
	
	@PostMapping("/init")
	public void init()
	{
		List<Race> races = new ArrayList<Race>();
		
		Race human = new Race
				(	1, 
					"Human", 
					"Your average human",
					"Mariah,Moira,Milly,Federica,Fabiana,Eleonora,Barbara,Marinela,Oxsana",
					"Diego,Giuseppe,Francesco,Nicolò,Stefano,Simone,Cosimo,Ferdinando,Francis,Vlad,Vash",
					120,
					170,
					65
				);
	
	
		Race orc = new Race
				(	2, 
					"Orc", 
					"Me smash",
					"Orchess,Orchette,Orchana,Patrizia,Fiona,Quela",
					"Shrek,Ork,Orch,Ogre,CannonFooder1,CannonFooder2,AlreadyDead,SnailBrain",
					1000,
					190,
					120
				);
		
		Race troll = new Race
				(	3, 
					"Troll", 
					"Me smash bigger",
					"Orchess,Orchette,Orchana,Patrizia,Fiona,Quela",
					"Shrek,Ork,Orch,Ogre,CannonFooder1,CannonFooder2,AlreadyDead,SnailBrain",
					1000,
					250,
					300
				);
		
		races.add(human);
		races.add(orc);
		races.add(troll);
		
		repoR.saveAll(races);
		
		List<Profession> professions = new ArrayList<Profession>();
		Profession grunt = 
			new Profession(1, "Grunt", "Cannon fooder", 0, 10, 0);
		Profession blackguard = 
				new Profession(2, "Blackguard", "Armored soldier", 20, 100, 1);
		Profession wizard =
				new Profession(3, "Wizard", "Binario 9 3/4", 50, 500, 2 );
		Profession shaman = 
				new Profession(4, "Shaman", "For the Tribe!", 50, 200, 2 );
		Profession archer = 
				new Profession(5, "Archer", "I have a bow", 10, 30, 1 );
		
		professions.add(grunt);
		professions.add(blackguard);
		professions.add(wizard);
		professions.add(shaman);
		professions.add(archer);
	
		repoP.saveAll(professions);
	}
	
	
}
