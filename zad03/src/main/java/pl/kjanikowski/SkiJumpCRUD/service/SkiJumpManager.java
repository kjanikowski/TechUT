package pl.kjanikowski.SkiJumpCRUD.service;

import java.util.List;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public interface SkiJumpManager {
	
	public boolean addSkiJump(SkiJump skiJump);
	public boolean deleteSkiJump(long id);
	public List<SkiJump> getAll();
	
	public boolean addAllSkiJumps(List<SkiJump> skiJumps);
	
	public SkiJump findByName(String name);

}
