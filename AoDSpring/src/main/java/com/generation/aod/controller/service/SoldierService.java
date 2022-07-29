package com.generation.aod.controller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aod.model.entities.Race;
import com.generation.aod.model.entities.Soldier;
import com.generation.aod.model.repository.RaceRepository;
import com.generation.aod.model.repository.SoldierFactory;
import com.generation.aod.model.repository.SoldierRepository;

@RestController
public class SoldierService
{
	
	@Autowired
	SoldierFactory soldierFactory;
	
	@Autowired
	SoldierRepository soldierRepo;
	
	@Autowired 
	RaceRepository raceRepo;
	
	
	@GetMapping("/soldiers/stats")
	public Map<String,Integer> getRacialsStats()
	{
		List<Race> races = raceRepo.findAll();
		Map<String, Integer> res = new HashMap<String,Integer>();
		for(Race race:races)
		{
			int total = 0;
			for(Soldier soldier : soldierRepo.findByRace(race))
				total+=soldier.getSalary();
			res.put(race.getName(), total);
			
		}	
		return res;
	}
	
	
	@GetMapping("/soldiers/detailstats")
	public Map<String,Map<String,Integer>> getDetailedRacialsStats()
	{
		List<Race> races = raceRepo.findAll();
		Map<String, Map<String,Integer>> res = new HashMap<String, Map<String,Integer>>();
		for(Race race:races)
		{
			int total = 0;
			int maximumSalary=0;
			int countOld = 0;
			int count = 0;
			for(Soldier soldier : soldierRepo.findByRace(race))
			{
				total+=soldier.getSalary();
				if(soldier.getSalary()>maximumSalary)
					maximumSalary = soldier.getSalary();
				
				count++;
				if(soldier.getAge()>= soldier.getRace().getMaxage()/2)
					countOld++;
			}
			Map<String,Integer> raceData = new HashMap<String,Integer>();
			raceData.put("members", count);
			raceData.put("oldmembers", countOld);
			raceData.put("totalsalary", total);
			raceData.put("highestpaid", maximumSalary);
			raceData.put("averagesalary", (int)(total / count));
			res.put(race.getName(), raceData);
			
		}	
		return res;
	}
	
	@GetMapping("/soldiers/detailstats/list")
	public List<Map<String,String>> getDetailedRacialsStatsList()
	{
		Map<String,Map<String,Integer>> data = getDetailedRacialsStats();
		List<Map<String,String>> res = new ArrayList<Map<String,String>>();
		for(String key:data.keySet())
		{
			Map<String,Integer> map = data.get(key);
			Map<String,String> newMap = new HashMap<String,String>();
			for(String key2:map.keySet())
				newMap.put(key2, map.get(key2)+"");
			newMap.put("race", key);
			res.add(newMap);
		}
		return res;
		
	}
	
	@PostMapping("/soldiers/random")
	public Soldier makeRandom()
	{
		Soldier soldier = soldierFactory.make(0);
		soldierRepo.save(soldier);
		return soldier;
		
	}
	
	@GetMapping("/soldiers")
	public List<Soldier> getAll()
	{
		return soldierRepo.findAll();
	}
	
	@GetMapping("/soldiers/{id}")
	public Soldier getOne(@PathVariable int id)
	{
		return soldierRepo.findById(id).get();
	}

}
