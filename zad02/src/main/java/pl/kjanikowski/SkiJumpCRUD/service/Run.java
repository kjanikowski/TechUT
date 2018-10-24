package pl.kjanikowski.SkiJumpCRUD.service;

import java.sql.Date;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public class Run {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date data = new Date(1992,12,12);

		SkiJump jump = new SkiJump("Malysza",120, data, true ); 
		
		SkiJumpManager test = new SkiJumpManagerJDBC();
		
		test.addSkiJump(jump);
		
		
		
		
	}

}
