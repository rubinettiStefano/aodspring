package com.generation.aod.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author rubin
 *
 */
@MappedSuperclass
public abstract class Entity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
		
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	

	public boolean isFull(String s)
	{
		return s!=null && !s.isEmpty();
	}
	
	public abstract boolean isValid();
	
	public abstract String generateInsert();
	
	
}
