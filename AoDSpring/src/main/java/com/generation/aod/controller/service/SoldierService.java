package com.generation.aod.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aod.model.entities.Soldier;
import com.generation.aod.model.repository.SoldierFactory;
import com.generation.aod.model.repository.SoldierRepository;

@RestController
public class SoldierService
{
	
	@Autowired
	SoldierFactory soldierFactory;
	
	@Autowired
	SoldierRepository soldierRepo;
	
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
