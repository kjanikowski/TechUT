package pl.kjanikowski.hibernate.service;

import java.util.List;

import pl.kjanikowski.hibernate.domain.SkiJump;

public interface SkiJumpManager {
	
	void addSkiJump(SkiJump skiJump);
	List<SkiJump> getAllSkiJumps();
	void deleteSkiJump(SkiJump skiJump);
	SkiJump findByName(String name);
	
	
	

}
