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
	public SessionFactory hs;


	@Override
	public void addSkiJump(SkiJump skiJump) {
		hs.getCurrentSession().persist(skiJump);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SkiJump> getAllSkiJumps() {
		// TODO Auto-generated method stub
		return hs.getCurrentSession().getNamedQuery("skiJump.getAll").list();
	}

	@Override
	public void removeSkiJump(long id) {
		SkiJump skijump = getSkiJump(id);
		hs.getCurrentSession().delete(skijump);
	}

	@Override
	public SkiJump getByName(String name) {
		// TODO Auto-generated method stub
		return (SkiJump) hs.getCurrentSession().getNamedQuery("skiJump.getByName").setString("name", name).uniqueResult();
	}

	@Override
	public SkiJump getSkiJump(long id) {
		// TODO Auto-generated method stub
		return (SkiJump) hs.getCurrentSession().get(SkiJump.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SkiJump> getAllByType(String type) {
		// TODO Auto-generated method stub
		return (List<SkiJump>) hs.getCurrentSession().getNamedQuery("skiJump.getAllByType").setString("type", type).list();
	}

	@Override
	public SkiJump getByCity(String city) {
		// TODO Auto-generated method stub
		return (SkiJump) hs.getCurrentSession().getNamedQuery("skiJump.getByCity").setString("name", city).uniqueResult();
	}

	

}
