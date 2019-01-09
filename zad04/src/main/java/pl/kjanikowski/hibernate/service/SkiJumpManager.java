package pl.kjanikowski.hibernate.service;

import java.util.List;

import pl.kjanikowski.hibernate.domain.City;
import pl.kjanikowski.hibernate.domain.Competition;
import pl.kjanikowski.hibernate.domain.SkiJump;
import pl.kjanikowski.hibernate.domain.SkiType;

public interface SkiJumpManager {
	
	void addSkiJump(SkiJump skiJump);
	List<SkiJump> getAllSkiJumps();
	void deleteSkiJump(SkiJump skiJump);
	SkiJump findByName(String name);
	
	
	void addCity(City city);
	List<City> getAllCities();
	void deleteCity(City city);
	
	void addCompetition(Competition competition);
	List<Competition> getCompetition();
	void deleteCompetition(Competition competition);
	
	void addSkiType(SkiType skiType);
	List<Competition> getSkiType();
	void deleteSkiType(SkiType skiType);
	
	

}
