package pl.kjanikowski.SkiJumpCRUD.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public class Run {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date data = new Date(112, 12, 12);
		Date data2 = new Date(112, 11, 7);

		SkiJump jump = new SkiJump("Skocznia Adama Malysza",120, data, true ); 
		SkiJump jump2 = new SkiJump("Oberstdorf",170, data2, true ); 
		SkiJump jump3 = new SkiJump("Engleberg",110, data, false ); 
		List<SkiJump> list = new ArrayList<SkiJump>();
		list.add(jump);
		list.add(jump2);
		
		
		
		SkiJumpManager test = new SkiJumpManagerJDBC();
		test.addSkiJump(jump3); //dodawanie pojedynczego
		System.out.println("Po dodaniu jednej skoczni:");
		for(SkiJump s : test.getAll()) {
			System.out.println(s.toString());
		}
		System.out.println("---------------------------------");
		test.addAllSkiJumps(list); //dodawanie wielu
		
		System.out.println("Po dodaniu kolejnych 2 skoczni:");
		
		for(SkiJump s : test.getAll()) {
			System.out.println(s.toString());
		}
		System.out.println("---------------------------------");
		
		test.deleteSkiJump(0); ///usuwanie
		System.out.println("Po usunieciu skoczni:");
		for(SkiJump s : test.getAll()) {
			System.out.println(s.toString());
		}
		
		System.out.println("---------------------------------");
		
		
		System.out.println("findByName():"+test.findByName("Oberstdorf").toString());
		System.out.println("---------------------------------");

		
		
		
		
		
	}

}
