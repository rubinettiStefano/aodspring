package com.generation.aod.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aod.model.entities.Profession;

public interface ProfessionRepository extends JpaRepository<Profession,Integer>
{

}
