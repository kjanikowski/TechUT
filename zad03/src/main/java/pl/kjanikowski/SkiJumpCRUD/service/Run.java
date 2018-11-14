package pl.kjanikowski.SkiJumpCRUD.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public class Run {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date data = new Date(1992,12,12);

		SkiJump jump = new SkiJump("Malysssdsdsdsdsdsszoaj",120, data, true ); 
		//SkiJump jump2 = new SkiJump("Oberstdorf",170, data, true ); 
		
		//List<SkiJump> list = new ArrayList<SkiJump>();
		//list.add(jump);
		//list.add(jump2);
		
		
		
		SkiJumpManager test = new SkiJumpManagerJDBC();
		test.addSkiJump(jump);

		
		//test.addAllSkiJumps(list);
		System.out.println(test.findByName("Malyszoj").toString());
		
		
		
		
		
	}

}
