package com.generation.aod.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/*
 * le annotation sono qualcosa di simile alle classi
 * e Java può`confondersi.
 * per evitarlo, possiamo fare extend dando il percorso completo
 * il package
 * ed evitando di conseguenza qualunque problema
 * 
 * 
 */

@Entity
public class Soldier extends com.generation.aod.model.entities.Entity
{

	String name, gender;
	int age;
	int height;
	int weight;
	int salary;
	
	@ManyToOne
	Race race;
	
	@ManyToOne
	Profession profession;
	
	
	
	
	
	public Soldier(int id, String name, String gender, int age, int height, int weight, int salary, Race race, Profession profession)
	{
		this.id 			= id;
		this.name 			= name;
		this.gender 		= gender;
		this.age			= age;
		this.height 		= height;
		this.weight 		= weight;
		this.salary 		= salary;
		this.race 			= race;
		this.profession 	= profession;
	}

	public Soldier() {}

	
	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public void setRandomGender()
	{
		setGender(Math.random() > 0.5 ? "M" : "F");
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public Race getRace()
	{
		return race;
	}

	public void setRace(Race race)
	{
		this.race = race;
	}

	public Profession getProfession()
	{
		return profession;
	}

	public void setProfession(Profession profession)
	{
		this.profession = profession;
	}

	@Override
	public boolean isValid()
	{
		return	isFull(name) && isFull(gender) && age>=18 && weight>0 && height>0 
				&& race!=null && profession!=null && salary>=0 && age < race.getMaxage()
				&& salary >= profession.getMinsalary() && salary <= profession.getMaxsalary()
				;
	}

	@Override
	public String generateInsert()
	{
		return 
				"Insert into Soldier(id,name,gender,age,height,weight,salary,raceid,professionid)"+
				"values([id], '[name]','[gender]',[age],[height], [weight], [salary], '[raceid]','[professionid]');"
				.replace("[id]", id+"")
				.replace("[name]", name)
				.replace("[gender]", gender)
				.replace("[age]", age+"")
				.replace("[height]", height+"")
				.replace("[weight]", weight+"")
				.replace("[salary]", salary+"")
				.replace("[raceid]", race.getId()+"")
				.replace("[professionid]", profession.getId()+"");
	}
	
	public void setRandomSalary()
	{
		if(profession==null)
			throw new RuntimeException("Profession unknown. Cannot generate salary");
		salary = profession.getRandomSalary();
	}

	public void setRandomAge() 
	{
		if(race==null)
			throw new RuntimeException("Race unknown. Cannot generate age");
		
		age = ((int)(Math.random()*((race.getMaxage()*0.75) - 18)) +18);
		
	}

	
	public void setRandomName()
	{
		if(race==null)
			throw new RuntimeException("Race unknown. Cannot generate name");
		if(gender==null)
			throw new RuntimeException("Gender unknown. Cannot generate name");
		
		setName(race.getRandomName(gender));
		
	}

	public void setRandomWeight()
	{
		if(race==null)
			throw new RuntimeException("Race unknown. Cannot generate weight");
		// metodo inefficiente ma più facile da seguire con la logica
		int delta =  (int)(race.getAverageweight() *0.2 *Math.random());
		
		setWeight
		(
				Math.random() >0.5 			  ?
				race.getAverageweight()+delta :
				race.getAverageweight()-delta 	
		);
	}

	public void setRandomHeight()
	{
		if(race==null)
			throw new RuntimeException("Race unknown. Cannot generate height");
		// metodo inefficiente ma più facile da seguire con la logica
		int delta =  (int)(race.getAverageheight() *0.2 *Math.random());
		
		setHeight
		(
				Math.random() >0.5 			  ?
				race.getAverageheight()+delta :
				race.getAverageheight()-delta 	
		);
		
	}
	
	
	
	
}
