package com.generation.aod;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.aod.model.entities.Profession;
import com.generation.aod.model.repository.ProfessionRepository;

@SpringBootTest
class AoDSpringApplicationTests {

	@Autowired
	ProfessionRepository repo;
	
	@Test
	void loadProfessions() 
	{
			List<Profession> content = new ArrayList<Profession>();
		
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
			
			content.add(grunt);
			content.add(blackguard);
			content.add(wizard);
			content.add(shaman);
			content.add(archer);
			
			repo.saveAll(content);
	}

}
