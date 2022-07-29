package com.generation.aod.model.entities;

@javax.persistence.Entity
public class Profession extends Entity
{
	String name, description;
	int minsalary, maxsalary;
	int level;
	

	
	
	public Profession(int id, String name, String description, int minsalary, int maxsalary, int level)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
		this.level = level;
	}

	public int getRandomSalary()
	{
		return ((int)(Math.random() * (maxsalary - minsalary))) + minsalary;		
	}

	public Profession(){}
	
	
	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public int getMinsalary()
	{
		return minsalary;
	}


	public void setMinsalary(int minsalary)
	{
		this.minsalary = minsalary;
	}


	public int getMaxsalary()
	{
		return maxsalary;
	}


	public void setMaxsalary(int maxsalary)
	{
		this.maxsalary = maxsalary;
	}

	@Override
	public boolean isValid()
	{
		return isFull(name) && isFull(description) && minsalary>=0 && maxsalary>=minsalary;
	}
	
	
	
	
	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	@Override
	public String generateInsert()
	{
		// TODO Auto-generated method stub
		return 	("insert into Profession (id,name, description, minsalary, maxsalary, level)  " +
				" values ([id], '[name]','[description]',[minsalary],[maxsalary], [level]);")
				.replace("[id]", id+"")
				.replace("[name]", name)
				.replace("[description]", description)
				.replace("[minsalary]", minsalary+"")
				.replace("[maxsalary]", maxsalary+"")
				.replace("[level]", level+"");
	}
	
	
	
	
}
