package com.generation.aod.model.entities;


/**
 * siccome questo è un mondo fantasy abbiamo le razze.
 * @author rubin
 *
 */
@javax.persistence.Entity
public class Race extends Entity
{
	String name;
	String description;	
	String femalenamescsv;
	String malenamescsv;
	
	int maxage;
	int averageheight; // espresso in cm
	int averageweight; // espressi in kg
	
	public Race() {}
	
	
	public Race(int id, String name, String description, String csvfemalenames, String csvmalenames, int maxage,
			int averageheight, int averageweight)
	{
		this.id 							= id;
		this.name 							= name;
		this.description 					= description;
		this.femalenamescsv					= csvfemalenames;
		this.malenamescsv 					= csvmalenames;
		this.maxage 						= maxage;
		this.averageheight 					= averageheight;
		this.averageweight 					= averageweight;
	}
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

	
	
	public String getFemalenamescsv()
	{
		return femalenamescsv;
	}


	public void setFemalenamescsv(String femalenamescsv)
	{
		this.femalenamescsv = femalenamescsv;
	}


	public String getMalenamescsv()
	{
		return malenamescsv;
	}


	public void setMalenamescsv(String malenamescsv)
	{
		this.malenamescsv = malenamescsv;
	}


	public int getMaxage()
	{
		return maxage;
	}
	public void setMaxage(int maxage)
	{
		this.maxage = maxage;
	}
	public int getAverageheight()
	{
		return averageheight;
	}
	public void setAverageheight(int averageheight)
	{
		this.averageheight = averageheight;
	}
	public int getAverageweight()
	{
		return averageweight;
	}
	public void setAverageweight(int averageweight)
	{
		this.averageweight = averageweight;
	}


	@Override
	public boolean isValid()
	{
		return 	isFull(name) 				&& 
				isFull(description) 		&& 
				averageweight>0 			&& 
				averageheight>0 			&& 
				isFull(malenamescsv)		&&
				isFull(femalenamescsv)		;
	}


	@Override
	public String generateInsert()
	{
		return ("insert into Race(id,name,description,femalenamescsv,malenamescsv,maxage,averageheight,averageweight) "
				+ "values( [id], '[name]','[description]','[femalenamescsv]','[malenamescsv]',[maxage],[averageheight],[averageweight]);")
				.replace("[id]", id +"")
				.replace("[name]",name)
				.replace("[description]",description)
				.replace("[femalenamescsv]",femalenamescsv)
				.replace("[malenamescsv]",malenamescsv) 
				.replace("[maxage]",maxage +"")
				.replace("[averageweight]",averageweight +"")
				.replace("[averageheight]",averageheight +"");

		
	}


	public String getRandomName(String gender)
	{
		String[] malenames = malenamescsv.split(",");
		String[] femalenames = femalenamescsv.split(",");
		
		return	gender.equals("M")											?
				malenames[(int)(Math.random() * malenames.length)]			:
				femalenames[(int)(Math.random() * femalenames.length)]		;
							
		
	}
	
	
	
	
}
