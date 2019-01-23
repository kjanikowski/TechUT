package pl.kjanikowski.hibernate.service;

import java.util.List;

import pl.kjanikowski.hibernate.domain.City;
import pl.kjanikowski.hibernate.domain.Competition;
import pl.kjanikowski.hibernate.domain.SkiJump;
import pl.kjanikowski.hibernate.domain.SkiType;

public interface SkiJumpManager {
	
	void addSkiJump(SkiJump skiJump);
	List<SkiJump> getAllSkiJumps();
	SkiJump getByName(String name);
	void removeSkiJump(long id);
	SkiJump getSkiJump(long id);
	List<SkiJump> getAllByType(String type);
	SkiJump getByCity(String city);
	
	

	
	

}
