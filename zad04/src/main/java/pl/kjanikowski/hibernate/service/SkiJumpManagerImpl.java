package pl.kjanikowski.hibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.kjanikowski.hibernate.domain.City;
import pl.kjanikowski.hibernate.domain.Competition;
import pl.kjanikowski.hibernate.domain.SkiJump;
import pl.kjanikowski.hibernate.domain.SkiType;
@Component
@Transactional
public class SkiJumpManagerImpl implements SkiJumpManager{
	
	
	@Autowired
	private SessionFactory hs;

	@Override
	public void addSkiJump(SkiJump skiJump) {
		hs.getCurrentSession().persist(skiJump);
	}

	@Override
	public List<SkiJump> getAllSkiJumps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSkiJump(SkiJump skiJump) {
		hs.getCurrentSession().delete(skiJump);
	}

	@Override
	public SkiJump findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCity(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCity(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCompetition(Competition competition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Competition> getCompetition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompetition(Competition competition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSkiType(SkiType skiType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Competition> getSkiType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSkiType(SkiType skiType) {
		// TODO Auto-generated method stub
		
	}

}
