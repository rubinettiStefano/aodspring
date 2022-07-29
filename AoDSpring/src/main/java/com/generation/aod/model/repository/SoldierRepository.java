package com.generation.aod.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aod.model.entities.Soldier;

public interface SoldierRepository extends JpaRepository<Soldier,Integer>
{

}
